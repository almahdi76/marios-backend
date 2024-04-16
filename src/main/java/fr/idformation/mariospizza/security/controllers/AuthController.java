package fr.idformation.mariospizza.security.controllers;

import fr.idformation.mariospizza.security.config.UserAuthenticationProvider;
import fr.idformation.mariospizza.security.dtos.CredentialsDto;
import fr.idformation.mariospizza.security.dtos.SignUpDto;
import fr.idformation.mariospizza.security.dtos.UserDto;
import fr.idformation.mariospizza.security.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AuthController {
    /**
     *inject user service.
     */
    private final UserService userService;
    /**
     *inject userAuth.
     */
    private final UserAuthenticationProvider userAuthenticationProvider;

    /**
     *
     * @param credentialsDto request for login.
     * @return user Dto
     */
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid final CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    /**
     *
     * @param user user Dto.
     * @return response dto
     * */
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid final SignUpDto user) {
        UserDto createdUser = userService.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

}
