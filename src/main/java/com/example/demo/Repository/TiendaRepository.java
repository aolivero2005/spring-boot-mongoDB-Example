package com.example.demo.Repository;

import com.example.demo.Model.Tienda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiendaRepository extends MongoRepository<Tienda, Long> {

    /**
     * Lista las tiendas de un estado
     * @param id
     * @return
     */
    @Query(value = "{ 'estado.$id' : ?0 }")
    List<Tienda> findByEstadoIdQuery(@Param("estado_id") Long id);

    /**
     * Lista las tiendas de una cadena
     * @param id
     * @return
     */
    @Query(value = "{ 'cadenaTienda.$id' : ?0 }")
    List<Tienda> findByCadenaIdQuery(@Param("cadena_id") Long id);


    /**
     * Lista las tiendas de un estado y de una cadena
     * @param estado_id
     * @param cadena_id
     * @return
     */
    @Query(value = "{ 'estado.$id' : ?0, 'cadenaTienda.$id' : ?1 }")
    List<Tienda> findByEstadoIdCadenaIdQuery(@Param("estado_id") Long estado_id, @Param("cadena_id") Long cadena_id);

    /**
     * Lista las tiendas que contengan la una descripción
     * @param descripcion
     * @return
     */
    List<Tienda> findByDescripcionContains(@Param("descripcion") String descripcion);

}
