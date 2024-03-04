package org.example;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private Long totalVentas;
    private String estado;

    public Cliente(Long id, String nombre, Long totalVentas, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.totalVentas = totalVentas;
        this.estado = estado;
    }

}
