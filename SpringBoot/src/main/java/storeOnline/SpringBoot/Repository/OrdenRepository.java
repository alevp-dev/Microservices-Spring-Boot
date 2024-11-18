package storeOnline.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import storeOnline.SpringBoot.Entity.OrdenEntity;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenEntity, Long> {
    @Query("SELECT o FROM OrdenEntity o WHERE " +
            "(:status IS NULL OR o.status = :status) ")
    List<OrdenEntity> filterOrders(@Param("status") String status);
}