package com.cut.cardona.modelo.voluntarios;

public record DatosMostrarVoluntarios(
        Long id,
        String nombre,
        String correo,
        String telefono,
        Boolean roll
) {

    public DatosMostrarVoluntarios(Vountarios vountarios) {
        this(vountarios.getId(), vountarios.getNombre(), vountarios.getTelefono(), vountarios.getRoll());    }

}

