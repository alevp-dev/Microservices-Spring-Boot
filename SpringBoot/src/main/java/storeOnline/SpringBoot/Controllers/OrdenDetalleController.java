package storeOnline.SpringBoot.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import storeOnline.SpringBoot.Entity.OrdenDetalleEntity;
import storeOnline.SpringBoot.Service.OrdenDetalleService;

@RestController
@RequestMapping({"/api/order/details"})
public class OrdenDetalleController {
    @Autowired
    private OrdenDetalleService ordenDetalleService;

    @GetMapping
    public List<OrdenDetalleEntity> getAllOrdersDetails() {
        return this.ordenDetalleService.getAllOrdersDetails();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<OrdenDetalleEntity> getOrderById(@PathVariable("id") Long idOrdenDetalle) {
        return this.ordenDetalleService.getOrderById(idOrdenDetalle).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrdenDetalleEntity createdOrderDetail(@RequestBody OrdenDetalleEntity ordenD) {
        return this.ordenDetalleService.createdOrderDetail(ordenD);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<OrdenDetalleEntity> updateOrderDetail(@PathVariable("id") Long idOrdenDetalle, @RequestBody OrdenDetalleEntity ordenDetails) {
        OrdenDetalleEntity updateOrder = this.ordenDetalleService.updateOrderDetail(idOrdenDetalle, ordenDetails);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<OrdenDetalleEntity> deleteOrderD(@PathVariable("id") Long idOrdenDetalle) {
        this.ordenDetalleService.deleteOrderD(idOrdenDetalle);
        return ResponseEntity.noContent().build();
    }
}
