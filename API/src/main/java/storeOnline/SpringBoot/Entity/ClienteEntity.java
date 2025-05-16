package storeOnline.SpringBoot.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@Schema(description = "Entidad que representa un cliente")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer", nullable = false)
    @Schema(description = "ID único del cliente", example = "1")
    private Long idCustomer;

    @Column(nullable = false, length = 50)
    @Schema(description = "Nombre del cliente", example = "Juan Pérez")
    private String customerName;

    @Column(nullable = false, length = 100)
    @Schema(description = "Email del cliente", example = "juan@email.com")
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
