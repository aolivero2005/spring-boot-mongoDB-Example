package com.example.demo.Controller;

import com.example.demo.Model.Duenno;
import com.example.demo.Repository.DuennoRepository;
import com.example.demo.Service.SequenceGeneratorService;
import com.example.demo.Service.ServiceException;
import com.example.demo.Service.implementations.DuennoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(tags="Dueño", value = "Dueño", description = "Crud para gestionar los dueños de las cadenas de tiendas")
public class DuennoController {

    @Autowired
    DuennoService duennoService;

    @GetMapping("/duenno")
    @ApiOperation(value = "Lista todos los dueños", notes = "Retorna una lista con todos los dueños")
    public List<Duenno> getAllDuennos() { return duennoService.getAllDuennos(); }

    @PostMapping("/duenno")
    @ApiOperation(value = "Inserta una dueño", notes = "Retorna el dueño insertado")
    public Duenno createDuenno(@Valid @RequestBody Duenno tienda) throws ServiceException {
        return duennoService.createDuenno(tienda) ;
    }
}
