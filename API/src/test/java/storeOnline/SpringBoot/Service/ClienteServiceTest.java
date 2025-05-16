package storeOnline.SpringBoot.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import storeOnline.SpringBoot.Entity.ClienteEntity;
import storeOnline.SpringBoot.Repository.ClienteRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {
    @Mock
    private ClienteRepository clienteRepository;
    @InjectMocks
    private ClienteService clienteService;

    private ClienteEntity cliente1;
    private ClienteEntity cliente2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente1 = new ClienteEntity(1L, "Cliente 1", "cliente1@mail.com", "123456789");
        cliente2 = new ClienteEntity(2L, "Cliente 2", "cliente2@mail.com", "987654321");
    }

    @Test
    void testGetAllCustomers() {
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

        List<ClienteEntity> result = clienteService.getAllCustomers();

        assertEquals(2, result.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    public void testCustomerById() {
        Long idCliente = 2L;
        ClienteEntity cliente = new ClienteEntity();
        cliente.setIdCustomer(idCliente);

        when(clienteRepository.findById(idCliente)).thenReturn(Optional.of(cliente));

        Optional<ClienteEntity> result = clienteService.getCustomerById(idCliente);

        assertTrue(result.isPresent());
        assertEquals(idCliente, result.get().getIdCustomer());
    }

    @Test
    void testCreateCustomer() {
        when(clienteRepository.save(cliente1)).thenReturn(cliente1);

        ClienteEntity result = clienteService.createCustomer(cliente1);

        assertEquals(cliente1.getCustomerName(), result.getCustomerName());
        verify(clienteRepository, times(1)).save(cliente1);
    }

    @Test
    void testUpdateCustomer() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente1));
        when(clienteRepository.save(cliente1)).thenReturn(cliente1);

        ClienteEntity newDetails = new ClienteEntity(1L, "Cliente Actualizado", "newemail@mail.com", "111222333");

        ClienteEntity result = clienteService.updateCustomer(1L, newDetails);

        assertEquals("Cliente Actualizado", result.getCustomerName());
        assertEquals("newemail@mail.com", result.getEmail());
        assertEquals("111222333", result.getTelefono());
        verify(clienteRepository, times(1)).findById(1L);
        verify(clienteRepository, times(1)).save(cliente1);
    }

    @Test
    void testDeleteCustomer() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente1));

        clienteService.deleteCustomer(1L);

        verify(clienteRepository, times(1)).findById(1L);
        verify(clienteRepository, times(1)).delete(cliente1);
    }

    @Test
    void testUpdateCustomer_NotFound() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            clienteService.updateCustomer(1L, cliente1);
        });

        assertEquals("Cliente no encontrado.", exception.getMessage());
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteCustomer_NotFound() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            clienteService.deleteCustomer(1L);
        });

        assertEquals("Cliente no encontrado.", exception.getMessage());
        verify(clienteRepository, times(1)).findById(1L);
    }
}
