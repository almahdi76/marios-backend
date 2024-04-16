package fr.idformation.mariospizza.security.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    /**
     *id.
     */
    private Long id;
    /**
     *first name.
     */
    private String firstName;
    /**
     *last name.
     */
    private String lastName;
    /**
     *phon number.
     */
    private String phonenumber;
    /**
     *address.
     */
    private String address;
    /**
     *token.
     */
    private String token;

}
