package storeOnline.SpringBoot.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import storeOnline.SpringBoot.Entity.InventarioEntity;
import storeOnline.SpringBoot.Repository.InventarioRepository;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    public InventarioService() {
    }

    public List<InventarioEntity> getAllInventory() {
        return this.inventarioRepository.findAll();
    }

    public Optional<InventarioEntity> getInventoryById(Long idInventario) {
        return this.inventarioRepository.findById(idInventario);
    }

    public InventarioEntity createInventory(InventarioEntity inventory) {
        return (InventarioEntity)this.inventarioRepository.save(inventory);
    }

    public InventarioEntity updateInventory(Long idInventario, InventarioEntity inventoryDetails) {
        InventarioEntity inventory = (InventarioEntity)this.inventarioRepository
                .findById(idInventario)
                .orElseThrow(() -> new RuntimeException("No se encuentra en el inventario."));
        inventory.setProductName(inventoryDetails.getProductName());
        inventory.setStock(inventoryDetails.getStock());
        inventory.setPrice(inventoryDetails.getPrice());
        return (InventarioEntity)this.inventarioRepository.save(inventory);
    }

    public void deleteInventory(Long idInventario) {
        InventarioEntity inventory = (InventarioEntity)this.inventarioRepository
                .findById(idInventario)
                .orElseThrow(() -> new RuntimeException("No se encuentra en el inventario"));
        this.inventarioRepository.delete(inventory);
    }
}