package com.example.demo.Service.implementations;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.Estados;
import com.example.demo.Repository.EstadosRepository;
import com.example.demo.Service.SequenceGeneratorService;
import com.example.demo.Service.ServiceException;
import com.example.demo.Service.interfaces.IEstados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadosService implements IEstados {

    @Autowired
    private EstadosRepository estadosRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    @Override
    public List<Estados> getAllEmployees(){
        return estadosRepository.findAll();
    };

    @Transactional
    @Override
    public Estados createEmployee(Estados estado) throws ServiceException {

        estado.setId(sequenceGeneratorService.generateSequence(com.example.demo.Model.Estados.SEQUENCE_NAME));
        return estadosRepository.save(estado);
    }

    @Transactional
    @Override
    public Estados updateEstado(Long estadoId, Estados estadoDetail) throws ServiceException{

        Estados estado = estadosRepository.findById(estadoId)
                .orElseThrow(() -> new ServiceException("Estado no encontrado por este id:: " + estadoId));

        estado.setCodigo(estadoDetail.getCodigo());
        estado.setDescripcion(estadoDetail.getDescripcion());
        Estados updatedEstado = estadosRepository.save(estado);
        return updatedEstado;
    }

    @Override
    public Estados getEstadosById(Long estadoId)
            throws ResourceNotFoundException {
        Estados estado = estadosRepository.findById(estadoId)
                .orElseThrow(() -> new ResourceNotFoundException("Estado no en contrado por este id:: " + estadoId));
        return estado;
    }

}
