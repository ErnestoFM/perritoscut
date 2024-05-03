package com.cut.cardona.controllers;

import com.cut.cardona.modelo.voluntarios.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class VoluntarioController {
    @Autowired
    private RepoVoluntarios repoVountarios;

    @GetMapping("/perros")
    public String alumnos(@ModelAttribute DatosVoluntario datosVoluntario, Model model){
        model.addAttribute("datosVoluntario",datosVoluntario);
        return "Voluntario";
    }


    @PostMapping("/perros")
    @Transactional
    public String crearAlumno(@ModelAttribute DatosVoluntario datosVoluntario){
        Vountarios vountarios = new Vountarios(datosVoluntario);
        repoVountarios.save(vountarios);
        return "redirect:/perros";
    }

    //metodo update
    @PostMapping("/perrosact")
    @Transactional
    public String actualizarVoluntario(@ModelAttribute DatosVoluntario datosActualizarVoluntario, Model model, @RequestParam Long voluntarioId) {
        Vountarios vountarios = repoVountarios.getReferenceById(voluntarioId);
        vountarios.actualizarDatos(datosActualizarVoluntario);
        return "redirect:/perros";
    }

    @ModelAttribute("perros")
    public List<DatosMostrarVoluntarios> mostrarVoluntarios(Model model){
        List<Vountarios> vountarios = repoVountarios.findAll();

        return repoVountarios.findAll().stream().map(DatosMostrarPerros::new).toList();
    }


    @GetMapping("/eliminar-perro")
    public String eliminar(@RequestParam Long id){
        Optional<Vountarios> byVountariosId = repoVountarios.findById(id);

        Optional<Vountarios> vountarios = repoVountarios.findById(id);
        vountarios.ifPresent(repoVountarios::delete);
        return "forward:/perros";
    }
}
