package storeOnline.SpringBoot.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import storeOnline.SpringBoot.Entity.ClienteEntity;
import storeOnline.SpringBoot.Repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService() {
    }

    public List<ClienteEntity> getAllCustomers() {
        return this.clienteRepository.findAll();
    }

    public Optional<ClienteEntity> getCustomerById(Long idCustomer) {
        return this.clienteRepository.findById(idCustomer);
    }

    public ClienteEntity createCustomer(ClienteEntity customer) {
        return (ClienteEntity)this.clienteRepository.save(customer);
    }

    public ClienteEntity updateCustomer(Long idCustomer, ClienteEntity customerDetails) {
        ClienteEntity customer = (ClienteEntity)this.clienteRepository.findById(idCustomer).orElseThrow(() -> new RuntimeException("Cliente no encontrado."));
        customer.setCustomerName(customerDetails.getCustomerName());
        customer.setEmail(customerDetails.getEmail());
        customer.setTelefono(customerDetails.getTelefono());
        return (ClienteEntity)this.clienteRepository.save(customer);
    }

    public void deleteCustomer(Long idCustomer) {
        ClienteEntity customer = (ClienteEntity)this.clienteRepository.findById(idCustomer).orElseThrow(() -> new RuntimeException("Cliente no encontrado."));
        this.clienteRepository.delete(customer);
    }
}