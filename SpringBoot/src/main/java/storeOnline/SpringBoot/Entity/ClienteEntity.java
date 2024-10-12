package storeOnline.SpringBoot.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer", nullable = false)
    private Long idCustomer;

    @Column(nullable = false, length = 50)
    private String customerName;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String telefono;

    @OneToMany(mappedBy = "customer")
    private List<OrdenEntity> ordenes;

    public ClienteEntity(Long idCustomer, String customerName, String email, String telefono) {
        this.idCustomer = idCustomer;
        this.customerName = customerName;
        this.email = email;
        this.telefono = telefono;
    }

    public ClienteEntity() {
    }

}
