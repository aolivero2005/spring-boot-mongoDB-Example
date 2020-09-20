package com.example.demo.Controller;

import com.example.demo.Model.CadenaTienda;
import com.example.demo.Model.Employee;
import com.example.demo.Repository.CadenaTiendaRepository;
import com.example.demo.Service.SequenceGeneratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(tags="Cadena de tienda", value = "Cadena de tiendas", description = "Crud para gestionar las cadenas de tienda")
public class CadenaTiendaController {

    @Autowired
    private CadenaTiendaRepository cadenaTiendaRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/cadena_tienda")
    @ApiOperation(value = "Inserta una cadena detienda", notes = "Retorna la cedena de tienda por id")
    public CadenaTienda createEmployee(@Valid @RequestBody CadenaTienda cadenaT) {
        cadenaT.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
        return cadenaTiendaRepository.save(cadenaT);
    }

    @GetMapping("/cadena_tienda")
    @ApiOperation(value = "Lista todas las cadenas de tiendas", notes = "Retorna una lista con todas las cadenas de tienda")
    public List<CadenaTienda> getAllTiendas() { return cadenaTiendaRepository.findAll(); }
}
