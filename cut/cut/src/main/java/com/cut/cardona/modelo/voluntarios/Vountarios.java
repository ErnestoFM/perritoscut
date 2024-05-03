package com.cut.cardona.modelo.voluntarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "voluntario")
@Entity(name = "Voluntario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Vountarios {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    private String correo;
    private String telefono;
    private String roll;

    public Vountarios(DatosVoluntario datosVoluntario) {
        this.id = datosVoluntario.id();
        this.nombre = datosVoluntario.nombre();
        this.correo = datosVoluntario.correo();
        this.telefono = datosVoluntario.telefono();
        this.roll = datosVoluntario.roll();
    }

    public void actualizarDatos(DatosVoluntario datosVoluntario) {
        if (datosVoluntario.nombre() != null && !datosVoluntario.nombre().isEmpty()) {
            this.nombre = datosVoluntario.nombre();
        }
        if (datosVoluntario.correo() != null && !datosVoluntario.edad().isEmpty()) {
            this.correo = datosVoluntario.correo();
        }
        if (datosVoluntario.telefono() != null && !datosVoluntario.raza().isEmpty()) {
            this.telefono = datosVoluntario.telefono();
        }
        if (datosVoluntario.roll() != null) {
            this.roll = datosVoluntario.roll();
        }

    }
}
