package storeOnline.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import storeOnline.SpringBoot.Entity.InventarioEntity;

@Repository
public interface InventarioRepository extends JpaRepository<InventarioEntity, Long> {
}