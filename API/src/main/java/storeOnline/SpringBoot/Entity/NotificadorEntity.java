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
@Table(name = "notificador")
@Getter
@Setter
public class NotificadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificador", nullable = false)
    private Long idNotificador;

    @ManyToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private OrdenEntity orden;

    @Column(nullable = false)
    private String notificadorType;

    @Column(nullable = false)
    private String status;

    public NotificadorEntity(Long idNotificador, OrdenEntity orden, String notificadorType, String status) {
        this.idNotificador = idNotificador;
        this.orden = orden;
        this.notificadorType = notificadorType;
        this.status = status;
    }

    public NotificadorEntity() {
    }
}