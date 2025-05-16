package storeOnline.SpringBoot.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import storeOnline.SpringBoot.Entity.OrdenEntity;
import storeOnline.SpringBoot.Service.OrdenService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping({"/api/orders"})
@Tag(name = "Órdenes", description = "API para gestionar órdenes de compra")
public class OrdenController {
    @Autowired
    private OrdenService ordenService;

    @Operation(summary = "Obtener todas las órdenes", description = "Retorna una lista de todas las órdenes existentes")
    @GetMapping
    public List<OrdenEntity> getAllOrders() {
        return this.ordenService.getAllOrders();
    }

    @Operation(summary = "Obtener una orden por ID", description = "Retorna una orden basada en su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Orden encontrada"),
        @ApiResponse(responseCode = "404", description = "Orden no encontrada")
    })
    @GetMapping({"/{id}"})
    public ResponseEntity<OrdenEntity> getOrderById(
            @Parameter(description = "ID de la orden", required = true) 
            @PathVariable("id") Long idOrden) {
        return this.ordenService.getOrderById(idOrden).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear una nueva orden", description = "Crea una nueva orden en el sistema")
    @PostMapping
    public ResponseEntity<OrdenEntity> createOrder(
            @Parameter(description = "Datos de la orden a crear", required = true)
            @RequestBody OrdenEntity orden) {
        try {
            OrdenEntity newOrder = this.ordenService.createOrder(orden);
            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
        } catch (IllegalArgumentException var3) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<OrdenEntity> updateOrder(@PathVariable("id") Long idOrden, @RequestBody OrdenEntity ordenDetails) {
        OrdenEntity updateOrder = this.ordenService.updateOrder(idOrden, ordenDetails);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<OrdenEntity> deleteOrder(@PathVariable("id") Long idOrden) {
        this.ordenService.deleteOrder(idOrden);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<OrdenEntity>> filterOrders(@RequestParam(required = false) String status) {
        List<OrdenEntity> orders = ordenService.filterOrders(status);
        return ResponseEntity.ok(orders);
    }

}

