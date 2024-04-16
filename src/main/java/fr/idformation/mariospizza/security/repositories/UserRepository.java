package fr.idformation.mariospizza.security.repositories;


import fr.idformation.mariospizza.security.entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    /**
     *
     * @param phonenumber phone.
     * @return user.
     */
    Optional<Users> findByPhonenumber(String phonenumber);
}
