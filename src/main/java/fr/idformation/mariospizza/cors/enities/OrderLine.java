package fr.idformation.mariospizza.cors.enities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

/**
 *jakarta persiste.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLine {
    /**
     * id.
     */
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * quantite.
     */
    @Column(nullable = false)
    private Integer quantity;
    /**
     * pizza.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "piz_id", nullable = false)
    private Pizza piz;
    /**
     * order.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ord_id", nullable = false)
    private Order ord;
}
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(final Long id) {
//        this.id = id;
//    }
//
//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(final Integer quantity) {
//        this.quantity = quantity;
//    }
//
//    public Pizza getPiz() {
//        return piz;
//    }
//
//    public void setPiz(final Pizza piz) {
//        this.piz = piz;
//    }
//
//    public Order getOrd() {
//        return ord;
//    }
//
//    public void setOrd(final Order ord) {
//        this.ord = ord;
//    }
//
//}
