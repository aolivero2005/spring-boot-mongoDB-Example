package com.example.demo.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Duenno")
public class Duenno {

    @Transient
    public static final String SEQUENCE_NAME = "duenno_sequence";

    @Id
    private long id;
    private String nombre;
    private String segNom;
    private String ap1;
    private String ap2;
}
