package com.example.demo.Service.implementations;

import com.example.demo.Model.Duenno;
import com.example.demo.Repository.DuennoRepository;
import com.example.demo.Service.SequenceGeneratorService;
import com.example.demo.Service.ServiceException;
import com.example.demo.Service.interfaces.IDuenno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class DuennoService implements IDuenno {

    @Autowired
    DuennoRepository duennoRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Duenno> getAllDuennos(){
        return duennoRepository.findAll();
    }

    @Transactional
    @Override
    public Duenno createDuenno(Duenno duenno) throws ServiceException {

        duenno.setId(sequenceGeneratorService.generateSequence(Duenno.SEQUENCE_NAME));
        return duennoRepository.save(duenno);
    }
}
