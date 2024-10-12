package storeOnline.SpringBoot.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import storeOnline.SpringBoot.Entity.OrdenDetalleEntity;
import storeOnline.SpringBoot.Entity.OrdenEntity;
import storeOnline.SpringBoot.Entity.ProductoEntity;
import storeOnline.SpringBoot.Repository.OrdenDetalleRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrdenDetalleServiceTest {
    @Mock
    private OrdenDetalleRepository ordenDetalleRepository;
    @InjectMocks
    private OrdenDetalleService ordenDetalleService;

    private OrdenEntity orden1;
    private ProductoEntity producto1;
    private OrdenEntity orden2;
    private ProductoEntity producto2;
    private OrdenDetalleEntity ordenD1;
    private OrdenDetalleEntity ordenD2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ordenD1 = new OrdenDetalleEntity(1L, orden1, producto1, 8);
        ordenD2 = new OrdenDetalleEntity(2L, orden2, producto2, 3);
    }

    @Test
    void testGetAllOrdenDetails() {
        when(ordenDetalleRepository.findAll()).thenReturn(Arrays.asList(ordenD1, ordenD2));

        List<OrdenDetalleEntity> result = ordenDetalleService.getAllOrdersDetails();

        assertEquals(2, result.size());
        verify(ordenDetalleRepository, times(1)).findAll();
    }

    @Test
    public void testGetOrdenDetailsById() {
        Long idOrdenD = 2L;
        OrdenDetalleEntity ordenD = new OrdenDetalleEntity();
        ordenD.setIdOrdenDetalle(2L);

        when(ordenDetalleRepository.findById(idOrdenD)).thenReturn(Optional.of(ordenD));

        Optional<OrdenDetalleEntity> result = ordenDetalleService.getOrderById(idOrdenD);

        assertTrue(result.isPresent());
        assertEquals(idOrdenD, result.get().getIdOrdenDetalle());
    }

    @Test
    void testCreateOrdenDetails() {
        when(ordenDetalleRepository.save(ordenD1)).thenReturn(ordenD1);

        OrdenDetalleEntity result = ordenDetalleService.createdOrderDetail(ordenD1);

        assertEquals(ordenD1.getAmount(), result.getAmount());
        verify(ordenDetalleRepository, times(1)).save(ordenD1);
    }

    @Test
    void testUpdateOrdenDetails() {
        when(ordenDetalleRepository.findById(1L)).thenReturn(Optional.of(ordenD1));
        when(ordenDetalleRepository.save(ordenD1)).thenReturn(ordenD1);

        OrdenDetalleEntity newDetails = new OrdenDetalleEntity(1L, orden2, producto1, 12);

        OrdenDetalleEntity result = ordenDetalleService.updateOrderDetail(1L, newDetails);

        assertEquals(orden2, result.getOrden());
        assertEquals(producto1, result.getProducto());
        assertEquals(12, result.getAmount());
        verify(ordenDetalleRepository, times(1)).findById(1L);
        verify(ordenDetalleRepository, times(1)).save(ordenD1);
    }

    @Test
    void testDeleteOrdenDetails() {
        when(ordenDetalleRepository.findById(2L)).thenReturn(Optional.of(ordenD2));

        ordenDetalleService.deleteOrderD(2L);

        verify(ordenDetalleRepository, times(1)).findById(2L);
        verify(ordenDetalleRepository, times(1)).delete(ordenD2);
    }

    @Test
    void testUpdateOrdenD_NotFound() {
        when(ordenDetalleRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            ordenDetalleService.updateOrderDetail(1L, ordenD1);
        });

        assertEquals("Detalle de la orden no encontrada.", exception.getMessage());
        verify(ordenDetalleRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteOrdenD_NotFound() {
        when(ordenDetalleRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            ordenDetalleService.deleteOrderD(1L);
        });

        assertEquals("Detalle de la orden no encontrada.", exception.getMessage());
        verify(ordenDetalleRepository, times(1)).findById(1L);
    }
}
