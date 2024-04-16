package fr.idformation.mariospizza.cors.enities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
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
public class Pizza {
    /**
     *id.
     */
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     *name.
     */
    @Column(nullable = false, length = 50)
    private String name;

    /**
     *description.
     */
    @Column(nullable = false, length = 200)
    private String description;
    /**
     *images.
     */
    @Column(nullable = false, length = 20)
    private String image;
    /**
     *price.
     */
    @Column(precision = 6, scale = 2)
    private BigDecimal price;
    /**
     *order line.
     */
    @OneToMany(mappedBy = "piz")
    private Set<OrderLine> pizOrderLines;
}

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(final Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(final String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(final String description) {
//        this.description = description;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(final String image) {
//        this.image = image;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(final BigDecimal price) {
//        this.price = price;
//    }
//
//    public Set<OrderLine> getPizOrderLines() {
//        return pizOrderLines;
//    }
//
//    public void setPizOrderLines(final Set<OrderLine> pizOrderLines) {
//        this.pizOrderLines = pizOrderLines;
//    }
//
//}
