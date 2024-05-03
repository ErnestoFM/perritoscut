package com.cut.cardona.modelo.voluntarios;

public record DatosRespuestaVoluntarios(

        Long id,
        String nombre,

        String correo,

        String telefono,
        String roll

) {

    public DatosRespuestaVoluntarios(Vountarios vountarios) {
        this(vountarios.getId(), vountarios.getNombre(), vountarios.getTelefono(), vountarios.getRoll());
    }

}
