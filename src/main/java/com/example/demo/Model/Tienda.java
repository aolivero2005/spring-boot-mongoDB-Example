package com.example.demo.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Tienda")
public class Tienda {

    @Transient
    public static final String SEQUENCE_NAME = "tienda_sequence";

    @Id
    private long id;
    private String descripcion;
    private String codigo;

    @DBRef(lazy = true)
    private Estados estado;

    @DBRef(lazy = true)
    private CadenaTienda cadenaTienda;

    @DBRef(lazy = true)
    private List<Almacen> almacenes;
}
