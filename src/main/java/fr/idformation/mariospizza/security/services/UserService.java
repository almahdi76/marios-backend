package fr.idformation.mariospizza.security.services;

import fr.idformation.mariospizza.security.dtos.CredentialsDto;
import fr.idformation.mariospizza.security.dtos.SignUpDto;
import fr.idformation.mariospizza.security.dtos.UserDto;
import fr.idformation.mariospizza.security.entites.Role;
import fr.idformation.mariospizza.security.entites.TypeDeRole;

import fr.idformation.mariospizza.security.entites.Users;
import fr.idformation.mariospizza.security.exceptions.AppException;
import fr.idformation.mariospizza.security.mappers.UserMapper;
import fr.idformation.mariospizza.security.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    /**
     *inject repo.
     */
    private final UserRepository userRepository;
    /**
     *inject pwd encoder.
     */
    private final PasswordEncoder passwordEncoder;
    /**
     *inject mapper.
     */
    private final UserMapper userMapper;

    /**
     *
     * @param credentialsDto sign in request.
     * @return user dto
     */
    public UserDto login(final CredentialsDto credentialsDto) {
        Users user = userRepository.findByPhonenumber(credentialsDto.phonenumber())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    /**
     *
     * @param userDto user dto.
     * @return user dto register
     */
    public UserDto register(final SignUpDto userDto) {

        Optional<Users> optionalUser = userRepository.findByPhonenumber(userDto.phonenumber());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }
        Role roleUser=Role.builder()
                .libelle(TypeDeRole.USER)
                .build();
        Users user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.password())));
        user.setRole(roleUser);
        Users savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    /**
     *
     * @param phone identifiant.
     * @return dto.
     */
    public UserDto findByPhonenumber(final String phone) {
        Users user = userRepository.findByPhonenumber(phone)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }
}


