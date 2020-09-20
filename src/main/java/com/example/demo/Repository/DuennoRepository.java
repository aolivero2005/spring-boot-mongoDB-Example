package com.example.demo.Repository;

import com.example.demo.Model.Duenno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DuennoRepository extends MongoRepository<Duenno, Long> {
}
