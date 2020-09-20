package com.example.demo.Controller;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.Estados;
import com.example.demo.Service.ServiceException;
import com.example.demo.Service.interfaces.IEstados;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(tags="Estados", value = "Estados", description = "Crud para gestionar los estados")
public class EstadosController {

    @Autowired
    IEstados iEstados;

    @GetMapping("/estados")
    @ApiOperation(value = "Lista todos los estados", notes = "Retorna una lista con todos los estados")
    public List<Estados> getAllEstados() {
        return iEstados.getAllEmployees();
    }

    @PostMapping("/estados")
    @ApiOperation(value = "Inserta un estado", notes = "Retorna el estado insertado")
    public Estados createEstado(@Valid @RequestBody Estados estado) throws ServiceException {
        return iEstados.createEmployee(estado);
    }

    @GetMapping("/estados/{id}")
    @ApiOperation(value = "Obtiene un estado dado su id", notes = "Retorna el estado")
    public ResponseEntity< Estados > getEstadosById(@PathVariable(value = "id") Long estadoId)
            throws ResourceNotFoundException {
        Estados estado = iEstados.getEstadosById(estadoId);
        return ResponseEntity.ok().body(estado);
    }

    @PutMapping("/estados/{id}")
    @ApiOperation(value = "Actualiza un estado dado su id", notes = "Retorna el estado actualizado")
    public ResponseEntity < Estados > updateEstado(@PathVariable(value = "id") Long estadoId,
                                                      @Valid @RequestBody Estados estadoDetails) throws Exception {
        Estados estado = iEstados.updateEstado(estadoId, estadoDetails);
        return ResponseEntity.ok(estado);

    }
}
