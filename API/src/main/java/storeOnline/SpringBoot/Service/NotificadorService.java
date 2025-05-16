package storeOnline.SpringBoot.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import storeOnline.SpringBoot.Entity.NotificadorEntity;
import storeOnline.SpringBoot.Repository.NotificadorRepository;

@Service
public class NotificadorService {
    @Autowired
    private NotificadorRepository notificadorRepository;

    public NotificadorService() {
    }

    public List<NotificadorEntity> getAllNotifier() {
        return this.notificadorRepository.findAll();
    }

    public Optional<NotificadorEntity> getNotifierById(Long idNotificador) {
        return this.notificadorRepository.findById(idNotificador);
    }

    public NotificadorEntity createNotifier(NotificadorEntity notificador) {
        return (NotificadorEntity)this.notificadorRepository.save(notificador);
    }

    public NotificadorEntity updateNotifier(Long idNotificador, NotificadorEntity notifierDetails) {
        NotificadorEntity notificador = (NotificadorEntity)this.notificadorRepository
                .findById(idNotificador)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));
        notificador.setNotificadorType(notifierDetails.getNotificadorType());
        notificador.setStatus(notifierDetails.getStatus());
        return (NotificadorEntity)this.notificadorRepository.save(notificador);
    }

    public void deleteNotifier(Long idNotificador) {
        NotificadorEntity notificador = (NotificadorEntity)this.notificadorRepository
                .findById(idNotificador)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));
        this.notificadorRepository.delete(notificador);
    }
}
