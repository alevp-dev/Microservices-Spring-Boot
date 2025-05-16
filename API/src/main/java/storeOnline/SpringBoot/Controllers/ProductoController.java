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
import storeOnline.SpringBoot.Entity.ProductoEntity;
import storeOnline.SpringBoot.Service.ProductoService;

@RestController
@RequestMapping({"/api/product"})
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoEntity> getAllProducts() {
        return this.productoService.getAllProducts();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<ProductoEntity> getProductsById(@PathVariable("id") Long idProduct) {
        return this.productoService.getProductsById(idProduct).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductoEntity createProducts(@RequestBody ProductoEntity producto) {
        return this.productoService.createProducts(producto);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<ProductoEntity> updateProducts(@PathVariable("id") Long idProduct, @RequestBody ProductoEntity productDetails) {
        ProductoEntity updateOrder = this.productoService.updateProducts(idProduct, productDetails);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<ProductoEntity> deleteProduct(@PathVariable("id") Long idProduct) {
        this.productoService.deleteProduct(idProduct);
        return ResponseEntity.noContent().build();
    }
}
