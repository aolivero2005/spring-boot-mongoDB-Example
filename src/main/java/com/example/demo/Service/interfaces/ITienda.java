package com.example.demo.Service.interfaces;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.Tienda;
import com.example.demo.Service.ServiceException;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface ITienda {

    public Tienda createTienda(Tienda t) throws ServiceException;

    public List<Tienda> getAllTiendas();

    public List<Tienda> getTiendasPorEstado(Long estadoId) throws ResourceNotFoundException;

    public List<Tienda> getTiendasPorCadena(Long cadenaId) throws ResourceNotFoundException;

    public List<Tienda> getTiendasPorEstadoAndCadena(Long estado_id, Long cadenaId) throws ResourceNotFoundException;

    public List<Tienda> findByDescripcionContaining(String descripcion);

}
