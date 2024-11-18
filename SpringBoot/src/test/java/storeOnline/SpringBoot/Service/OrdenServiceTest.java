package storeOnline.SpringBoot.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import storeOnline.SpringBoot.Entity.ClienteEntity;
import storeOnline.SpringBoot.Entity.OrdenEntity;
import storeOnline.SpringBoot.Repository.ClienteRepository;
import storeOnline.SpringBoot.Repository.OrdenRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class OrdenServiceTest {
    @Mock
    private OrdenRepository ordenRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private OrdenService ordenService;

    private OrdenEntity orden1;
    private OrdenEntity orden2;
    private ClienteEntity cliente1;
    private ClienteEntity cliente2;

    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        cliente1 = new ClienteEntity(1L, "Cliente 1", "cliente1@mail.com", "123456789");
        cliente2 = new ClienteEntity(2L, "Cliente 2", "cliente2@mail.com", "987654321");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse("2024-10-12");
        Date date2 = dateFormat.parse("2024-10-11");
        orden1 = new OrdenEntity(1L, cliente1, "Completada", date1);
        orden2 = new OrdenEntity(2L, cliente2, "Pendiente", date2);

    }

    @Test
    void testGetAllOrders() {
        when(ordenRepository.findAll()).thenReturn(Arrays.asList(orden1));

        List<OrdenEntity> result = ordenService.getAllOrders();

        assertEquals(1, result.size());
        assertEquals(orden1, result.get(0));

        verify(ordenRepository, times(1)).findAll();
    }

    @Test
    void testGetOrderById() {
        when(ordenRepository.findById(2L)).thenReturn(Optional.of(orden1));

        Optional<OrdenEntity> result = ordenService.getOrderById(2L);

        assertTrue(result.isPresent());
        assertEquals(orden1, result.get());

        verify(ordenRepository, times(1)).findById(2L);
    }

    @Test
    void testCreateOrder() {
        when(clienteRepository.findById(2L)).thenReturn(Optional.of(cliente2));

        when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(cliente2);

        when(ordenRepository.save(any(OrdenEntity.class))).thenReturn(orden2);

        OrdenEntity result = ordenService.createOrder(orden2);

        assertNotNull(result);
        assertEquals(orden2, result);

        verify(clienteRepository, times(1)).findById(2L);
        verify(ordenRepository, times(1)).save(any(OrdenEntity.class));
    }

    @Test
    void testUpdateOrder() {
        when(ordenRepository.findById(1L)).thenReturn(Optional.of(orden1));
        when(ordenRepository.save(any(OrdenEntity.class))).thenReturn(orden1);

        OrdenEntity result = ordenService.updateOrder(1L, orden1);

        assertNotNull(result);
        assertEquals(orden1, result);

        verify(ordenRepository, times(1)).findById(1L);
        verify(ordenRepository, times(1)).save(any(OrdenEntity.class));
    }

    @Test
    void testDeleteOrder() {
        when(ordenRepository.findById(1L)).thenReturn(Optional.of(orden1));

        ordenService.deleteOrder(1L);

        verify(ordenRepository, times(1)).findById(1L);
        verify(ordenRepository, times(1)).delete(any(OrdenEntity.class));
    }

    @Test
    void testFilterOrders() {
        List<OrdenEntity> mockOrders = List.of(orden1);

        Mockito.when(ordenRepository.filterOrders("Completada")).thenReturn(mockOrders);

        List<OrdenEntity> result = ordenService.filterOrders("Completada");

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Completada", result.get(0).getStatus());
    }
}
