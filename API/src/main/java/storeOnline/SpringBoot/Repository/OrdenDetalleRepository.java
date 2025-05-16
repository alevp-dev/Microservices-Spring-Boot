package storeOnline.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import storeOnline.SpringBoot.Entity.OrdenDetalleEntity;

@Repository
public interface OrdenDetalleRepository extends JpaRepository<OrdenDetalleEntity, Long> {
}