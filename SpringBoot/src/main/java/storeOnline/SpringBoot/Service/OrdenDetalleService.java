package storeOnline.SpringBoot.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import storeOnline.SpringBoot.Entity.OrdenDetalleEntity;
import storeOnline.SpringBoot.Repository.OrdenDetalleRepository;

@Service
public class OrdenDetalleService {
    @Autowired
    private OrdenDetalleRepository ordenDetalleRepository;

    public OrdenDetalleService() {
    }

    public List<OrdenDetalleEntity> getAllOrdersDetails() {
        return this.ordenDetalleRepository.findAll();
    }

    public Optional<OrdenDetalleEntity> getOrderById(Long idOrdenDetalle) {
        return this.ordenDetalleRepository.findById(idOrdenDetalle);
    }

    public OrdenDetalleEntity createdOrderDetail(OrdenDetalleEntity ordenDetail) {
        return (OrdenDetalleEntity)this.ordenDetalleRepository.save(ordenDetail);
    }

    public OrdenDetalleEntity updateOrderDetail(Long idOrdenDetalle, OrdenDetalleEntity orderDetail) {
        OrdenDetalleEntity ordenD = (OrdenDetalleEntity)this.ordenDetalleRepository
                .findById(idOrdenDetalle)
                .orElseThrow(() -> new RuntimeException("Detalle de la orden no encontrada."));
        ordenD.setProducto(orderDetail.getProducto());
        ordenD.setAmount(orderDetail.getAmount());
        return (OrdenDetalleEntity)this.ordenDetalleRepository.save(ordenD);
    }

    public void deleteOrderD(Long idOrdenDetalle) {
        OrdenDetalleEntity ordenD = (OrdenDetalleEntity)this.ordenDetalleRepository
                .findById(idOrdenDetalle)
                .orElseThrow(() -> new RuntimeException("Detalle de la orden no encontrada."));
        this.ordenDetalleRepository.delete(ordenD);
    }
}