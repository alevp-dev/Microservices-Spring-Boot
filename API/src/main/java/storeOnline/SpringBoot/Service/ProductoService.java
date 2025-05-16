package storeOnline.SpringBoot.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import storeOnline.SpringBoot.Entity.ProductoEntity;
import storeOnline.SpringBoot.Repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public ProductoService() {
    }

    public List<ProductoEntity> getAllProducts() {
        return this.productoRepository.findAll();
    }

    public Optional<ProductoEntity> getProductsById(Long idProduct) {
        return this.productoRepository.findById(idProduct);
    }

    public ProductoEntity createProducts(ProductoEntity productDetail) {
        return (ProductoEntity)this.productoRepository.save(productDetail);
    }

    public ProductoEntity updateProducts(Long idProduct, ProductoEntity productDetail) {
        ProductoEntity producto = (ProductoEntity)this.productoRepository
                .findById(idProduct)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado."));
        producto.setProductName(productDetail.getProductName());
        producto.setPriceProduct(productDetail.getPriceProduct());
        return (ProductoEntity)this.productoRepository.save(producto);
    }

    public void deleteProduct(Long idProduct) {
        ProductoEntity producto = (ProductoEntity)this.productoRepository
                .findById(idProduct)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado."));
        this.productoRepository.delete(producto);
    }
}
