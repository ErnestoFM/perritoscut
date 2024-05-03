package com.cut.cardona.controllers;
import com.cut.cardona.modelo.perros.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
public class PerroController {

    @Autowired
    private RepositorioPerro repositorioPerro;


    @GetMapping("/perros")
    public String alumnos(@ModelAttribute DatosPerro datosPerro, Model model){
        model.addAttribute("datosPerros",datosPerro);
        return "perros";
    }


    @PostMapping("/perros")
    @Transactional
    public String crearAlumno(@ModelAttribute DatosPerro datosPerro
    ){
        Perro perro = new Perro(datosPerro);
        repositorioPerro.save(perro);
        return "redirect:/perros";
    }

    //metodo update
    @PostMapping("/perrosact")
    @Transactional
    public String actualizarPerro(@ModelAttribute DatosPerro datosActualizarPerro, Model model, @RequestParam Long perroId) {
        Perro perro = repositorioPerro.getReferenceById(perroId);
        perro.actualizarDatos(datosActualizarPerro);
        return "redirect:/perros";
    }

    @ModelAttribute("perros")
    public List<DatosMostrarPerros> mostrarPerros(Model model){
        List<Perro> perros = repositorioPerro.findAll();

        return repositorioPerro.findAll().stream().map(DatosMostrarPerros::new).toList();
    }


    @GetMapping("/eliminar-perro")
    public String eliminar(@RequestParam Long id){
        Optional<Perro> byPerroId = repositorioPerro.findById(id);

        Optional<Perro> perro = repositorioPerro.findById(id);
        perro.ifPresent(repositorioPerro::delete);
        return "forward:/perros";
    }

    /*@PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaPerros> crearPerro(@RequestBody DatosPerro datosPerro, UriComponentsBuilder uriComponentsBuilder){

        Perro perro = repositorioPerro.save(new Perro(datosPerro));
        repositorioPerro.findAll();
        URI uri = uriComponentsBuilder.path("/perros/{id}").buildAndExpand(perro.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosRespuestaPerros(perro));
    }*/

}
