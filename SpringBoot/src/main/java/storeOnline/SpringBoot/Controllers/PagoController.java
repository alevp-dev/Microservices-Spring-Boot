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
import storeOnline.SpringBoot.Entity.PagoEntity;
import storeOnline.SpringBoot.Service.PagoService;

@RestController
@RequestMapping({"/api/pays"})
public class PagoController {
    @Autowired
    private PagoService pagoService;

    @GetMapping
    public List<PagoEntity> getAllPays() {
        return this.pagoService.getAllPays();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<PagoEntity> getPaysById(@PathVariable("id") Long idPago) {
        return this.pagoService.getPaysById(idPago).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PagoEntity createPays(@RequestBody PagoEntity pago) {
        return this.pagoService.createPays(pago);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<PagoEntity> updatePays(@PathVariable("id") Long idPago, @RequestBody PagoEntity pagoDetail) {
        PagoEntity updateOrder = this.pagoService.updatePays(idPago, pagoDetail);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<PagoEntity> deleteOrder(@PathVariable("id") Long idPago) {
        this.pagoService.deletePay(idPago);
        return ResponseEntity.noContent().build();
    }
}
