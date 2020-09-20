package com.example.demo.Repository;


import com.example.demo.Model.CadenaTienda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadenaTiendaRepository extends MongoRepository<CadenaTienda, Long> {

}
