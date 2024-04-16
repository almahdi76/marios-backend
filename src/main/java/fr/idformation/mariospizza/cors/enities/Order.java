package fr.idformation.mariospizza.cors.enities;

import fr.idformation.mariospizza.security.entites.Users;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;



import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

/**
 * les entities.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "\"Order\"")
public class Order {
    /**
     * id.
     */
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * date.
     */
    @Column(nullable = false)
    private OffsetDateTime date;
    /**
     * price.
     */
    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal totalAmount;
    /**
     * users.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_id", nullable = false)
    private Users usr;
    /**
     * order line.
     */
    @OneToMany(mappedBy = "ord")
    private Set<OrderLine> ordOrderLines;
}

//    public Long getId()
//    {
//        return id;
//    }
//
//    public void setId(final Long id) {
//        this.id = id;
//    }
//
//    public OffsetDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(final OffsetDateTime date) {
//        this.date = date;
//    }
//
//    public BigDecimal getTotalAmount() {
//        return totalAmount;
//    }
//
//    public void setTotalAmount(final BigDecimal totalAmount) {
//        this.totalAmount = totalAmount;
//    }
//
//    public Users getUsr() {
//        return usr;
//    }
//
//    public void setUsr(final Users usr) {
//        this.usr = usr;
//    }
//
//    public Set<OrderLine> getOrdOrderLines() {
//        return ordOrderLines;
//    }
//
//    public void setOrdOrderLines(final Set<OrderLine> ordOrderLines) {
//        this.ordOrderLines = ordOrderLines;
//    }
//}
