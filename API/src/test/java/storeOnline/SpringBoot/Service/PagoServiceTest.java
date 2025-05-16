package storeOnline.SpringBoot.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import storeOnline.SpringBoot.Entity.PagoEntity;
import storeOnline.SpringBoot.Repository.PagoRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PagoServiceTest {
    @Mock
    private PagoRepository pagoRepository;
    @InjectMocks
    private PagoService pagoService;

    private PagoEntity pago1;
    private PagoEntity pago2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pago1 = new PagoEntity(1L, "Completado", 65.000, "Tarjeta");
        pago2 = new PagoEntity(2L, "Pendiente", 100.000, "Tarjeta");
    }

    @Test
    void testGetAllPays() {
        when(pagoRepository.findAll()).thenReturn(Arrays.asList(pago1, pago2));

        List<PagoEntity> result = pagoService.getAllPays();

        assertEquals(2, result.size());
        verify(pagoRepository, times(1)).findAll();
    }

    @Test
    public void testGetPayById() {
        Long idPago = 2L;
        PagoEntity pago = new PagoEntity();
        pago.setIdPago(idPago);

        when(pagoRepository.findById(idPago)).thenReturn(Optional.of(pago));

        Optional<PagoEntity> result = pagoService.getPaysById(idPago);

        assertTrue(result.isPresent());
        assertEquals(idPago, result.get().getIdPago());
    }

    @Test
    void testCreatePay() {
        when(pagoRepository.save(pago1)).thenReturn(pago1);

        PagoEntity result = pagoService.createPays(pago1);

        assertEquals(pago1.getPagoMethod(), result.getPagoMethod());
        verify(pagoRepository, times(1)).save(pago1);
    }

    @Test
    void testUpdatePay() {
        when(pagoRepository.findById(2L)).thenReturn(Optional.of(pago2));
        when(pagoRepository.save(pago2)).thenReturn(pago2);

        PagoEntity newDetails = new PagoEntity(2L, "Completado", 100.000, "Tarjeta");

        PagoEntity result = pagoService.updatePays(2L, newDetails);

        assertEquals("Completado", result.getPagoStatus());
        assertEquals(100.000, result.getAmount());
        assertEquals("Tarjeta", result.getPagoMethod());
        verify(pagoRepository, times(1)).findById(2L);
        verify(pagoRepository, times(1)).save(pago2);
    }

    @Test
    void testDeletePay() {
        when(pagoRepository.findById(1L)).thenReturn(Optional.of(pago1));

        pagoService.deletePay(1L);

        verify(pagoRepository, times(1)).findById(1L);
        verify(pagoRepository, times(1)).delete(pago1);
    }

    @Test
    void testUpdatePay_NotFound() {
        when(pagoRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            pagoService.updatePays(1L, pago1);
        });

        assertEquals("Pago de la orden no encontrado.", exception.getMessage());
        verify(pagoRepository, times(1)).findById(1L);
    }

    @Test
    void testDeletePay_NotFound() {
        when(pagoRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            pagoService.deletePay(1L);
        });

        assertEquals("Pago de la orden no encontrado.", exception.getMessage());
        verify(pagoRepository, times(1)).findById(1L);
    }
}
