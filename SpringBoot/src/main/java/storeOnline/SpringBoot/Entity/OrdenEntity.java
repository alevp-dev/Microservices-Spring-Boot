package storeOnline.SpringBoot.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orden")
@Getter
@Setter
public class OrdenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden", nullable = false)
    private Long idOrden;

    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false)
    @JsonBackReference
    private ClienteEntity customer;

    @Column(nullable = false, length = 10)
    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    public OrdenEntity(Long idOrden, ClienteEntity customer, String status, Date createdDate) {
        this.idOrden = idOrden;
        this.customer = customer;
        this.status = status;
        this.createdDate = createdDate;
    }

    public OrdenEntity() {
    }
}