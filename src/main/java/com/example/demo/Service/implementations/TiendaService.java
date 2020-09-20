package com.example.demo.Service.implementations;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.CadenaTienda;
import com.example.demo.Model.Estados;
import com.example.demo.Model.Tienda;
import com.example.demo.Repository.CadenaTiendaRepository;
import com.example.demo.Repository.EstadosRepository;
import com.example.demo.Repository.TiendaRepository;
import com.example.demo.Service.SequenceGeneratorService;
import com.example.demo.Service.ServiceException;
import com.example.demo.Service.interfaces.ITienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TiendaService implements ITienda {

    @Autowired
    TiendaRepository tiendaRepository;

    @Autowired
    EstadosRepository estadosRepository;

    @Autowired
    CadenaTiendaRepository cadenaTiendaRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Tienda> getAllTiendas(){
        return tiendaRepository.findAll();
    };

    @Transactional
    @Override
    public Tienda createTienda(Tienda tienda) throws ServiceException {

        tienda.setId(sequenceGeneratorService.generateSequence(Tienda.SEQUENCE_NAME));
        return tiendaRepository.save(tienda);
    }

    @Override
    public List<Tienda> getTiendasPorEstado(Long estadoId)
            throws ResourceNotFoundException {

        Estados estado = estadosRepository.findById(estadoId)
                .orElseThrow(() -> new ResourceNotFoundException("Estado no encontrado por este id:: " + estadoId));

        List<Tienda> tiendas = tiendaRepository.findByEstadoIdQuery(estado.getId());
        return tiendas;
    }

    @Override
    public List<Tienda> getTiendasPorCadena(Long cadenaId)
            throws ResourceNotFoundException {

        CadenaTienda cadena = cadenaTiendaRepository.findById(cadenaId)
                .orElseThrow(() -> new ResourceNotFoundException("Cadena de tieda no encontrada por este id:: " + cadenaId));

        List<Tienda> tiendas = tiendaRepository.findByCadenaIdQuery(cadena.getId());
        return tiendas;
    }

    @Override
    public List<Tienda> getTiendasPorEstadoAndCadena(Long estado_id, Long cadenaId) throws ResourceNotFoundException{

        Estados estado = estadosRepository.findById(estado_id)
                .orElseThrow(() -> new ResourceNotFoundException("Estado no encontrada por este id:: " + cadenaId));

        CadenaTienda cadena = cadenaTiendaRepository.findById(cadenaId)
                .orElseThrow(() -> new ResourceNotFoundException("Cadena de tieda no encontrada por este id:: " + cadenaId));

        List<Tienda> tiendas = tiendaRepository.findByEstadoIdCadenaIdQuery(estado.getId(), cadena.getId());
        return tiendas;
    }

    public List<Tienda> findByDescripcionContaining(String descripcion){
        return tiendaRepository.findByDescripcionContains(descripcion);
    }

}
