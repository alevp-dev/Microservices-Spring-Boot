package storeOnline.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import storeOnline.SpringBoot.Entity.OrdenEntity;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenEntity, Long> {
}