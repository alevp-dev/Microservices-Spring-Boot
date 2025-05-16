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
import storeOnline.SpringBoot.Entity.NotificadorEntity;
import storeOnline.SpringBoot.Service.NotificadorService;

@RestController
@RequestMapping({"/api/notifier"})
public class NotificadorController {
    @Autowired
    private NotificadorService notificadorService;

    @GetMapping
    public List<NotificadorEntity> getAllNotifier() {
        return this.notificadorService.getAllNotifier();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<NotificadorEntity> getNotifierById(@PathVariable("id") Long idNotificador) {
        return this.notificadorService.getNotifierById(idNotificador).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NotificadorEntity createNotifier(@RequestBody NotificadorEntity notificador) {
        return this.notificadorService.createNotifier(notificador);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<NotificadorEntity> updateNotifier(@PathVariable("id") Long idNotificador, @RequestBody NotificadorEntity notificadorDetails) {
        NotificadorEntity updateOrder = this.notificadorService.updateNotifier(idNotificador, notificadorDetails);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<NotificadorEntity> deleteNotifier(@PathVariable("id") Long idNotificador) {
        this.notificadorService.deleteNotifier(idNotificador);
        return ResponseEntity.noContent().build();
    }
}
