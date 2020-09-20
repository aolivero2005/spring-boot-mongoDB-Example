package com.example.demo.Model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Estados")
public class Estados {

    @Transient
    public static final String SEQUENCE_NAME = "estado_sequence";

    @ApiModelProperty(notes = "Identificador unico autogenerado para el estado", example = "1", required = false)
    @Id
    private long id;

    @ApiModelProperty(notes = "Descripción del estado", example = "New York", required = true)
    @NotEmpty
    @Size(max = 100)
    @Indexed(unique = true, sparse=true)
    private String descripcion;

    @ApiModelProperty(notes = "Código para el estado", example = "NY", required = false)
    @NotEmpty
    @Size(max = 5)
    @Indexed(unique = true)
    private String codigo;

}
