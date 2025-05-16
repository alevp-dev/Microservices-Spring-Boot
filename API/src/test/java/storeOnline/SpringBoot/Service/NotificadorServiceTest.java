package storeOnline.SpringBoot.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import storeOnline.SpringBoot.Entity.NotificadorEntity;
import storeOnline.SpringBoot.Entity.OrdenEntity;
import storeOnline.SpringBoot.Repository.NotificadorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NotificadorServiceTest {
    @Mock
    private NotificadorRepository notificadorRepository;
    @InjectMocks
    private NotificadorService notificadorService;

    private NotificadorEntity notificador1;
    private NotificadorEntity notificador2;
    private OrdenEntity orden1;
    private OrdenEntity orden2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        notificador1 = new NotificadorEntity(1L, orden1, "Text", "Completado");
        notificador2 = new NotificadorEntity(2L, orden2, "Email", "Pendiente");
    }

    @Test
    void testGetAllNotifier() {
        when(notificadorRepository.findAll()).thenReturn(Arrays.asList(notificador1, notificador2));

        List<NotificadorEntity> result = notificadorService.getAllNotifier();

        assertEquals(2, result.size());
        verify(notificadorRepository, times(1)).findAll();
    }

    @Test
    public void testGetNotifierById() {
        Long idNotificador = 2L;
        NotificadorEntity cliente = new NotificadorEntity();
        cliente.setIdNotificador(idNotificador);

        when(notificadorRepository.findById(idNotificador)).thenReturn(Optional.of(cliente));

        Optional<NotificadorEntity> result = notificadorService.getNotifierById(idNotificador);

        assertTrue(result.isPresent());
        assertEquals(idNotificador, result.get().getIdNotificador());
    }

    @Test
    void testCreateNotifier() {
        when(notificadorRepository.save(notificador1)).thenReturn(notificador1);

        NotificadorEntity result = notificadorService.createNotifier(notificador1);

        assertEquals(notificador1.getNotificadorType(), result.getNotificadorType());
        verify(notificadorRepository, times(1)).save(notificador1);
    }

    @Test
    void testUpdateNotifier() {
        when(notificadorRepository.findById(2L)).thenReturn(Optional.of(notificador2));
        when(notificadorRepository.save(notificador2)).thenReturn(notificador2);

        NotificadorEntity newDetails = new NotificadorEntity(2L, orden2, "Email", "Completado");

        NotificadorEntity result = notificadorService.updateNotifier(2L, newDetails);

        assertEquals(orden2, result.getOrden());
        assertEquals("Email", result.getNotificadorType());
        assertEquals("Completado", result.getStatus());
        verify(notificadorRepository, times(1)).findById(2L);
        verify(notificadorRepository, times(1)).save(notificador2);
    }

    @Test
    void testDeleteNotifier() {
        when(notificadorRepository.findById(1L)).thenReturn(Optional.of(notificador1));

        notificadorService.deleteNotifier(1L);

        verify(notificadorRepository, times(1)).findById(1L);
        verify(notificadorRepository, times(1)).delete(notificador1);
    }

    @Test
    void testUpdateNotifier_NotFound() {
        when(notificadorRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            notificadorService.updateNotifier(1L, notificador1);
        });

        assertEquals("Notificación no encontrada", exception.getMessage());
        verify(notificadorRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteCustomer_NotFound() {
        when(notificadorRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            notificadorService.deleteNotifier(1L);
        });

        assertEquals("Notificación no encontrada", exception.getMessage());
        verify(notificadorRepository, times(1)).findById(1L);
    }
}
