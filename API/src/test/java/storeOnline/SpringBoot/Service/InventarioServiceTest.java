package storeOnline.SpringBoot.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import storeOnline.SpringBoot.Entity.InventarioEntity;
import storeOnline.SpringBoot.Repository.InventarioRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class InventarioServiceTest {
    @Mock
    private InventarioRepository inventarioRepository;
    @InjectMocks
    private InventarioService inventarioService;

    private InventarioEntity inventario1;
    private InventarioEntity inventario2;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        inventario1 = new InventarioEntity(1L, "Rubor", 30, 20.000);
        inventario2 = new InventarioEntity(2L, "Polvo", 25, 18.000);
    }
    @Test
    public void testGetAllInventories() {
        when(inventarioRepository.findAll()).thenReturn(Arrays.asList(inventario1));

        List<InventarioEntity> result = inventarioService.getAllInventory();

        assertEquals(1, result.size());
        verify(inventarioRepository, times(1)).findAll();
    }
    
    @Test
    public void testGetInventoryById() {
        Long idInventario = 1L;
        InventarioEntity inventario = new InventarioEntity();
        inventario.setIdInventario(idInventario);
        
        when(inventarioRepository.findById(idInventario)).thenReturn(Optional.of(inventario));
        
        Optional<InventarioEntity> result = inventarioService.getInventoryById(idInventario);
        
        assertTrue(result.isPresent());
        assertEquals(idInventario, result.get().getIdInventario());
    }

    @Test
    public void testCreateInventory() {
        when(inventarioRepository.save(inventario2)).thenReturn(inventario2);

        InventarioEntity result = inventarioService.createInventory(inventario2);

        assertEquals(inventario2.getProductName(), result.getProductName());
        verify(inventarioRepository, times(1)).save(inventario2);
    }

    @Test
    void testUpdateInventory() {
        when(inventarioRepository.findById(1L)).thenReturn(Optional.of(inventario1));
        when(inventarioRepository.save(inventario1)).thenReturn(inventario1);

        InventarioEntity newDetails = new InventarioEntity(1L, "Rubor", 10, 20.000);

        InventarioEntity result = inventarioService.updateInventory(1L, newDetails);

        assertEquals("Rubor", result.getProductName());
        assertEquals(10, result.getStock());
        assertEquals(20.000, result.getPrice());
        verify(inventarioRepository, times(1)).findById(1L);
        verify(inventarioRepository, times(1)).save(inventario1);
    }

    @Test
    void testDeleteInventory() {
        when(inventarioRepository.findById(2L)).thenReturn(Optional.of(inventario2));

        inventarioService.deleteInventory((2L));

        verify(inventarioRepository, times(1)).findById(2L);
        verify(inventarioRepository, times(1)).delete(inventario2);
    }

    @Test
    void testUpdateInventory_NotFound() {
        // Preparar el mock para lanzar excepción cuando no se encuentre el cliente
        when(inventarioRepository.findById(2L)).thenReturn(Optional.empty());

        // Verificar que se lanza la excepción correcta
        Exception exception = assertThrows(RuntimeException.class, () -> {
            inventarioService.updateInventory(2L, inventario2);
        });

        assertEquals("No se encuentra en el inventario.", exception.getMessage());
        verify(inventarioRepository, times(1)).findById(2L);
    }

    @Test
    void testDeleteInventory_NotFound() {
        // Preparar el mock para lanzar excepción cuando no se encuentre el cliente
        when(inventarioRepository.findById(2L)).thenReturn(Optional.empty());

        // Verificar que se lanza la excepción correcta
        Exception exception = assertThrows(RuntimeException.class, () -> {
            inventarioService.deleteInventory(2L);
        });

        assertEquals("No se encuentra en el inventario.", exception.getMessage());
        verify(inventarioRepository, times(1)).findById(2L);
    }
}
