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
import storeOnline.SpringBoot.Entity.OrdenDetalleEntity;
import storeOnline.SpringBoot.Service.OrdenDetalleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping({"/api/order/details"})
@Tag(name = "Detalles de Orden", description = "API para la gestión de detalles de órdenes")
public class OrdenDetalleController {
    @Autowired
    private OrdenDetalleService ordenDetalleService;

    @Operation(summary = "Obtener todos los detalles de órdenes", description = "Retorna una lista de todos los detalles de órdenes")
    @ApiResponse(responseCode = "200", description = "Lista de detalles obtenida exitosamente")
    @GetMapping
    public List<OrdenDetalleEntity> getAllOrdersDetails() {
        return this.ordenDetalleService.getAllOrdersDetails();
    }

    @Operation(summary = "Obtener detalle de orden por ID", description = "Retorna un detalle de orden específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Detalle de orden encontrado"),
        @ApiResponse(responseCode = "404", description = "Detalle de orden no encontrado")
    })
    @GetMapping({"/{id}"})
    public ResponseEntity<OrdenDetalleEntity> getOrderById(
            @Parameter(description = "ID del detalle de orden", required = true)
            @PathVariable("id") Long idOrdenDetalle) {
        return this.ordenDetalleService.getOrderById(idOrdenDetalle).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrdenDetalleEntity createdOrderDetail(@RequestBody OrdenDetalleEntity ordenD) {
        return this.ordenDetalleService.createdOrderDetail(ordenD);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<OrdenDetalleEntity> updateOrderDetail(@PathVariable("id") Long idOrdenDetalle, @RequestBody OrdenDetalleEntity ordenDetails) {
        OrdenDetalleEntity updateOrder = this.ordenDetalleService.updateOrderDetail(idOrdenDetalle, ordenDetails);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<OrdenDetalleEntity> deleteOrderD(@PathVariable("id") Long idOrdenDetalle) {
        this.ordenDetalleService.deleteOrderD(idOrdenDetalle);
        return ResponseEntity.noContent().build();
    }
}
