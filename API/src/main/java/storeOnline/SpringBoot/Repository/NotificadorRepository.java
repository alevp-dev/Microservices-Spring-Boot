package storeOnline.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import storeOnline.SpringBoot.Entity.NotificadorEntity;

@Repository
public interface NotificadorRepository extends JpaRepository<NotificadorEntity, Long> {
}