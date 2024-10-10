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
import storeOnline.SpringBoot.Entity.ClienteEntity;
import storeOnline.SpringBoot.Service.ClienteService;

@RestController
@RequestMapping({"/api/customer"})
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteEntity> getAllCustomers() {
        return this.clienteService.getAllCustomers();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<ClienteEntity> getCustomerById(@PathVariable("id") Long idCustomer) {
        return this.clienteService.getCustomerById(idCustomer).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClienteEntity createCustomer(@RequestBody ClienteEntity customer) {
        return this.clienteService.createCustomer(customer);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<ClienteEntity> updateCustomer(@PathVariable("id") Long idCustomer, @RequestBody ClienteEntity customerDetails) {
        ClienteEntity updateOrder = this.clienteService.updateCustomer(idCustomer, customerDetails);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<ClienteEntity> deleteCustumer(@PathVariable("id") Long idCustomer) {
        this.clienteService.deleteCustomer(idCustomer);
        return ResponseEntity.noContent().build();
    }
}