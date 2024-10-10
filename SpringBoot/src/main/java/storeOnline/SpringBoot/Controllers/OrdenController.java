package storeOnline.SpringBoot.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import storeOnline.SpringBoot.Entity.OrdenEntity;
import storeOnline.SpringBoot.Service.OrdenService;

@RestController
@RequestMapping({"/api/orders"})
public class OrdenController {
    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public List<OrdenEntity> getAllOrders() {
        return this.ordenService.getAllOrders();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<OrdenEntity> getOrderById(@PathVariable("id") Long idOrden) {
        return this.ordenService.getOrderById(idOrden).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrdenEntity> createOrder(@RequestBody OrdenEntity orden) {
        try {
            OrdenEntity newOrder = this.ordenService.createOrder(orden);
            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
        } catch (IllegalArgumentException var3) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<OrdenEntity> updateOrder(@PathVariable("id") Long idOrden, @RequestBody OrdenEntity ordenDetails) {
        OrdenEntity updateOrder = this.ordenService.updateOrder(idOrden, ordenDetails);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<OrdenEntity> deleteOrder(@PathVariable("id") Long idOrden) {
        this.ordenService.deleteOrder(idOrden);
        return ResponseEntity.noContent().build();
    }
}

