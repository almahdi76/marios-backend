package fr.idformation.mariospizza.security.mappers;

import fr.idformation.mariospizza.security.dtos.SignUpDto;
import fr.idformation.mariospizza.security.dtos.UserDto;
import fr.idformation.mariospizza.security.entites.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    /**
     *
     * @param users user.
     * @return dto
     */
    UserDto toUserDto(Users users);

    /**
     *
     * @param signUpDto dto.
     * @return entity
     */
    @Mapping(target = "password", ignore = true)

    Users signUpToUser(SignUpDto signUpDto);

}
