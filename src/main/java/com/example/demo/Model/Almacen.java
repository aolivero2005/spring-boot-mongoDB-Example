package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Almacen")
public class Almacen {

    @Transient
    public static final String SEQUENCE_NAME = "almacen_sequence";

    @Id
    private long id;
    private String descripcion;
    private String codigo;
}
