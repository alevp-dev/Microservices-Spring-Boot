package storeOnline.SpringBoot.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import storeOnline.SpringBoot.Entity.PagoEntity;
import storeOnline.SpringBoot.Repository.PagoRepository;

@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    public PagoService() {
    }

    public List<PagoEntity> getAllPays() {
        return this.pagoRepository.findAll();
    }

    public Optional<PagoEntity> getPaysById(Long idPago) {
        return this.pagoRepository.findById(idPago);
    }

    public PagoEntity createPays(PagoEntity pago) {
        return (PagoEntity)this.pagoRepository.save(pago);
    }

    public PagoEntity updatePays(Long idPago, PagoEntity pagoDetail) {
        PagoEntity pago = (PagoEntity)this.pagoRepository.findById(idPago).orElseThrow(() -> new RuntimeException("Pago de la orden no encontrado."));
        pago.setPagoStatus(pagoDetail.getPagoStatus());
        pago.setAmount(pagoDetail.getAmount());
        pago.setPagoMethod(pagoDetail.getPagoMethod());
        return (PagoEntity)this.pagoRepository.save(pago);
    }

    public void deletePay(Long idPago) {
        PagoEntity pago = (PagoEntity)this.pagoRepository.findById(idPago).orElseThrow(() -> new RuntimeException("Pago de la orden no encontrado."));
        this.pagoRepository.delete(pago);
    }
}