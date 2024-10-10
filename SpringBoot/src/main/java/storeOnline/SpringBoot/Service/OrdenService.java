package storeOnline.SpringBoot.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import storeOnline.SpringBoot.Entity.ClienteEntity;
import storeOnline.SpringBoot.Entity.OrdenEntity;
import storeOnline.SpringBoot.Repository.ClienteRepository;
import storeOnline.SpringBoot.Repository.OrdenRepository;

@Service
public class OrdenService {
    @Autowired
    private OrdenRepository ordenRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public OrdenService() {
    }

    public List<OrdenEntity> getAllOrders() {
        return this.ordenRepository.findAll();
    }

    public Optional<OrdenEntity> getOrderById(Long idOrden) {
        return this.ordenRepository.findById(idOrden);
    }

    public OrdenEntity createOrder(OrdenEntity orden) {
        if (orden.getCustomer().getIdCustomer() == null) {
            ClienteEntity newCustomer = new ClienteEntity();
            newCustomer.setCustomerName(orden.getCustomer().getCustomerName());
            newCustomer.setEmail(orden.getCustomer().getEmail());
            newCustomer.setTelefono(orden.getCustomer().getTelefono());
            ClienteEntity createdCustomer = (ClienteEntity)this.clienteRepository.save(newCustomer);
            orden.setCustomer(createdCustomer);
        } else {
            ClienteEntity existingCustomer = (ClienteEntity)this.clienteRepository
                    .findById(orden.getCustomer().getIdCustomer())
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + orden.getCustomer().getIdCustomer()));
            orden.setCustomer(existingCustomer);
        }

        return (OrdenEntity)this.ordenRepository.save(orden);
    }

    public OrdenEntity updateOrder(Long idOrder, OrdenEntity ordenDetails) {
        OrdenEntity orden = (OrdenEntity)this.ordenRepository.findById(idOrder).orElseThrow(() -> new RuntimeException("Orden no encontrada."));
        orden.setCustomer(ordenDetails.getCustomer());
        orden.setStatus(ordenDetails.getStatus());
        orden.setCreatedDate(ordenDetails.getCreatedDate());
        return (OrdenEntity)this.ordenRepository.save(orden);
    }

    public void deleteOrder(Long idOrder) {
        OrdenEntity orden = (OrdenEntity)this.ordenRepository.findById(idOrder).orElseThrow(() -> new RuntimeException("Orden no encontrada."));
        this.ordenRepository.delete(orden);
    }
}