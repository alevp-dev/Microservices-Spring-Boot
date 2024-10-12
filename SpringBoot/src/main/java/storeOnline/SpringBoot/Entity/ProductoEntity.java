package storeOnline.SpringBoot.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto")
@Getter
@Setter
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false)
    private Long idProduct;

    @Column(nullable = false, length = 100)
    private String productName;

    @Column(nullable = false)
    private Double priceProduct;

    @ManyToOne
    @JoinColumn(name = "id_inventario", nullable = false)
    private InventarioEntity inventario;

    public ProductoEntity(Long idProduct, String productName, Double priceProduct, InventarioEntity inventario) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.priceProduct = priceProduct;
        this.inventario = inventario;
    }

    public ProductoEntity() {
    }
}