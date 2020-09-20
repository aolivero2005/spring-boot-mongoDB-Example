package com.example.demo.Service.interfaces;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.Estados;
import com.example.demo.Service.ServiceException;

import java.util.List;

public interface IEstados {

    /**
     * Obtiene una lista con todos los estados
     * @return List
     */
    public List<Estados> getAllEmployees();
    public Estados createEmployee(Estados estado) throws ServiceException;
    public Estados updateEstado(Long estadoId, Estados estadoDetail) throws ServiceException;
    public Estados getEstadosById(Long employeeId) throws ResourceNotFoundException;
}
