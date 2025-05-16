package storeOnline.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import storeOnline.SpringBoot.Entity.PagoEntity;

@Repository
public interface PagoRepository extends JpaRepository<PagoEntity, Long> {
}