package storeOnline.SpringBoot.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import storeOnline.SpringBoot.Entity.InventarioEntity;
import storeOnline.SpringBoot.Entity.ProductoEntity;
import storeOnline.SpringBoot.Repository.ProductoRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductoServiceTest {
    @Mock
    private ProductoRepository productoRepository;
    @InjectMocks
    private ProductoService productoService;

    private ProductoEntity producto1;
    private ProductoEntity producto2;
    private InventarioEntity inventario1;
    private InventarioEntity inventario2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        producto1 = new ProductoEntity(1L, "Rubor", 20.000, inventario1);
        producto2 = new ProductoEntity(2L, "Polvo", 25.000, inventario2);
    }

    @Test
    void testGetAllProducts() {
        // Preparar el comportamiento del mock
        when(productoRepository.findAll()).thenReturn(Arrays.asList(producto1, producto2));

        // Ejecutar el método a probar
        List<ProductoEntity> result = productoService.getAllProducts();

        // Verificar los resultados
        assertEquals(2, result.size());
        verify(productoRepository, times(1)).findAll();
    }

    @Test
    public void testGetProdutById() {
        Long idProducto = 2L;
        ProductoEntity producto = new ProductoEntity();
        producto.setIdProduct(idProducto);

        when(productoRepository.findById(idProducto)).thenReturn(Optional.of(producto));

        Optional<ProductoEntity> result = productoService.getProductsById(idProducto);

        assertTrue(result.isPresent());
        assertEquals(idProducto, result.get().getIdProduct());
    }

    @Test
    void testCreateProducts() {
        when(productoRepository.save(producto1)).thenReturn(producto1);

        ProductoEntity result = productoService.createProducts(producto1);

        assertEquals(producto1.getProductName(), result.getProductName());
        verify(productoRepository, times(1)).save(producto1);
    }

    @Test
    void testUpdateProduct() {
        when(productoRepository.findById(2L)).thenReturn(Optional.of(producto2));
        when(productoRepository.save(producto2)).thenReturn(producto2);

        ProductoEntity newDetails = new ProductoEntity(2L, "Polvo", 35.000, inventario2);

        ProductoEntity result = productoService.updateProducts(2L, newDetails);

        assertEquals("Polvo", result.getProductName());
        assertEquals(35.000, result.getPriceProduct());
        assertEquals(inventario2, result.getInventario());
        verify(productoRepository, times(1)).findById(2L);
        verify(productoRepository, times(1)).save(producto2);
    }

    @Test
    void testDeleteProduct() {
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto1));

        productoService.deleteProduct(1L);

        verify(productoRepository, times(1)).findById(1L);
        verify(productoRepository, times(1)).delete(producto1);
    }

    @Test
    void testUpdateProduct_NotFound() {
        when(productoRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            productoService.updateProducts(1L, producto1);
        });

        assertEquals("Producto no encontrado.", exception.getMessage());
        verify(productoRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteProduct_NotFound() {
        when(productoRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            productoService.deleteProduct(1L);
        });

        assertEquals("Producto no encontrado.", exception.getMessage());
        verify(productoRepository, times(1)).findById(1L);
    }
}
