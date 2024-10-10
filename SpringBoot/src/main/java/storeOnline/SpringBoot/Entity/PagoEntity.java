package storeOnline.SpringBoot.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pagos")
@Getter
@Setter
public class PagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago", nullable = false)
    private Long idPago;

    @ManyToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private OrdenEntity orden;

    @Column(nullable = false)
    private String pagoStatus;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String pagoMethod;
}
