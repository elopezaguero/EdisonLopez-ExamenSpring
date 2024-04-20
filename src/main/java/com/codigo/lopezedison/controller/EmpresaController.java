package com.codigo.lopezedison.controller;

import com.codigo.lopezedison.entity.EmpresaEntity;
import com.codigo.lopezedison.service.IEmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/examenSpring/v1/empresa")
@AllArgsConstructor
@Tag(
        name = "API para el Mantenimiento de Empresas",
        description = "Esta api contiene todos los end points para realizar el mantenimiento en Entidad Empresa"
)
public class EmpresaController {

    private final IEmpresaService iEmpresaService;

    @Operation(summary = "Crear nueva Empresa")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "El mensaje con código 200 se muestra cuando la empresa ha sido creada exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @PostMapping("/crear")
    public ResponseEntity<EmpresaEntity> crear(@RequestBody EmpresaEntity empresaEntity){
        return ResponseEntity.ok(iEmpresaService.crear(empresaEntity));
    }

    @Operation(summary = "Buscar empresas ingresando el código ID")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa encontrada exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<EmpresaEntity>> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(iEmpresaService.buscarXId(id));
    }

    @Operation(summary = "Muestra todo el listado de empresas")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Listado de empresas de forma exitosa",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @GetMapping("/todos")
    public ResponseEntity<List<EmpresaEntity>> buscarTodos(){
        return ResponseEntity.ok(iEmpresaService.BuscarAll());
    }

    @Operation(summary = "Actualización de datos de empresas tomando como parámetro de entrada su ID y datos a modificar")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa actualizada exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EmpresaEntity> actualizar(@PathVariable Long id, @RequestBody EmpresaEntity empresaEntity){
        return ResponseEntity.ok(iEmpresaService.actualizar(id, empresaEntity));
    }

    @Operation(summary = "Eliminación lógica de la Empresa")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa eliminada exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<EmpresaEntity> eliminar(@PathVariable Long id){
        return ResponseEntity.ok(iEmpresaService.borrar(id));
    }
}
