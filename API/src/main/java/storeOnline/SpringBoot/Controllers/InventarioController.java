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
import storeOnline.SpringBoot.Entity.InventarioEntity;
import storeOnline.SpringBoot.Service.InventarioService;

@RestController
@RequestMapping({"/api/inventory"})
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    public InventarioController() {
    }

    @GetMapping
    public List<InventarioEntity> getAllInventory() {
        return this.inventarioService.getAllInventory();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<InventarioEntity> getInventoryById(@PathVariable("id") Long idInventario) {
        return this.inventarioService.getInventoryById(idInventario).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InventarioEntity createInventory(@RequestBody InventarioEntity inventory) {
        return this.inventarioService.createInventory(inventory);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<InventarioEntity> updateInventory(@PathVariable("id") Long idInventario, @RequestBody InventarioEntity inventoryDetails) {
        InventarioEntity updateOrder = this.inventarioService.updateInventory(idInventario, inventoryDetails);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<InventarioEntity> deleteOrder(@PathVariable("id") Long idInventario) {
        this.inventarioService.deleteInventory(idInventario);
        return ResponseEntity.noContent().build();
    }
}
