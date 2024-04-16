package fr.idformation.mariospizza.security.entites;

import fr.idformation.mariospizza.cors.enities.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
/**
 *annutations.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity

@Table(name = "users")
public class Users {
    /**
     *id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     *firstname.
     */
    @Column(name = "firstname", nullable = false)
    @Size(max = 100)
    private String firstName;
    /**
     *lastname.
     */
    @Column(name = "lastname", nullable = false)
    @Size(max = 100)
    private String lastName;
    /**
     *phone.
     */
    @Column(nullable = false)
    @Size(max = 100)
    private String phonenumber;
    /**
     *password.
     */
    @Column(nullable = false)
    @Size(max = 100)
    private String password;
    /**
     *address.
     */
    private String address;
    /**
     *role.
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Role role;
    /**
     *user order.
     */
       @OneToMany(mappedBy = "usr")
    private Set<Order> usrOrders;

}
