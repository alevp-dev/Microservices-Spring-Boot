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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping({"/api/customer"})
@Tag(name = "Clientes", description = "API para la gestión de clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Obtener todos los clientes", description = "Retorna una lista de todos los clientes registrados")
    @ApiResponse(responseCode = "200", description = "Lista de clientes obtenida exitosamente")
    @GetMapping
    public List<ClienteEntity> getAllCustomers() {
        return this.clienteService.getAllCustomers();
    }

    @Operation(summary = "Obtener cliente por ID", description = "Retorna un cliente específico basado en su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @GetMapping({"/{id}"})
    public ResponseEntity<ClienteEntity> getCustomerById(
            @Parameter(description = "ID del cliente", required = true) 
            @PathVariable("id") Long idCustomer) {
        return this.clienteService.getCustomerById(idCustomer).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear nuevo cliente", description = "Crea un nuevo cliente en el sistema")
    @ApiResponse(responseCode = "200", description = "Cliente creado exitosamente")
    @PostMapping
    public ClienteEntity createCustomer(
            @Parameter(description = "Datos del cliente a crear", required = true)
            @RequestBody ClienteEntity customer) {
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