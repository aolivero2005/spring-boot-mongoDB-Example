package com.example.demo.Controller;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.Tienda;
import com.example.demo.Repository.TiendaRepository;
import com.example.demo.Service.SequenceGeneratorService;
import com.example.demo.Service.ServiceException;
import com.example.demo.Service.implementations.TiendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.rmi.CORBA.Tie;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(tags="Tienda", value = "Tienda", description = "Crud para gestionar las tiendas")
public class TiendaControlller {

    @Autowired
    TiendaService tiendaService;

    @PostMapping("/tienda")
    @ApiOperation(value = "Inserta una tienda", notes = "Retorna la tienda insertada")
    public Tienda createTienda(@Valid @RequestBody Tienda tienda) throws ServiceException {
        return tiendaService.createTienda(tienda);
    }

    @GetMapping("/tienda")
    @ApiOperation(value = "Lista todos las tiendas", notes = "Retorna una lista con todas las tiendas")
    public List<Tienda> getAllTiendas() { return tiendaService.getAllTiendas(); }

    @GetMapping("/tienda/nombreContaing")
    @ApiOperation(value = "Lista todos las tiendas que contengan la descripción", notes = "Retorna una lista con todas las tiendas que contengan la descripción")
    public List<Tienda> findByDescripcionContaining(@Param("descripcion") String descripcion) { return tiendaService.findByDescripcionContaining(descripcion); }

    @GetMapping("/tienda/estado/{id}")
    @ApiOperation(value = "Obtiene una lista con las tiends de un estado", notes = "Retorna una lista de las tiendas de un estado")
    public ResponseEntity<List<Tienda>> getTiendaPorEstado(@PathVariable(value = "id") Long estadoId)
            throws ResourceNotFoundException {
        List<Tienda> tienda = tiendaService.getTiendasPorEstado(estadoId);
        return ResponseEntity.ok().body(tienda);
    }

    @GetMapping("/tienda/cadena/{id}")
    @ApiOperation(value = "Obtiene una lista con las tiends de un cadena", notes = "Retorna una lista de las tiendas de un cadena")
    public ResponseEntity<List<Tienda>> getTiendasPorCadena(@PathVariable(value = "id") Long cadenaId)
            throws ResourceNotFoundException {
        List<Tienda> tienda = tiendaService.getTiendasPorCadena(cadenaId);
        return ResponseEntity.ok().body(tienda);
    }

    @GetMapping("/tienda/estado/{estado_id}/cadena/{cadena_id}")
    @ApiOperation(value = "Obtiene una lista con las tiends de un estado y de una cadena", notes = "Retorna una lista de las tiendas de un estado y deuna cadena")
    public ResponseEntity<List<Tienda>> getTiendasPorCadena(@PathVariable(value = "estado_id") Long estadoId, @PathVariable(value = "cadena_id") Long cadenaId)
            throws ResourceNotFoundException {
        List<Tienda> tienda = tiendaService.getTiendasPorEstadoAndCadena(estadoId, cadenaId);
        return ResponseEntity.ok().body(tienda);
    }

}
