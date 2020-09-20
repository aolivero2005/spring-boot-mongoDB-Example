package com.example.demo.Repository;

import com.example.demo.Model.Estados;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadosRepository extends MongoRepository<Estados, Long> {
}
