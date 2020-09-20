package com.example.demo.Service.interfaces;

import com.example.demo.Model.Duenno;
import com.example.demo.Service.ServiceException;

import java.util.List;


public interface IDuenno {

    public List<Duenno> getAllDuennos();
    public Duenno createDuenno(Duenno d) throws ServiceException;

}
