/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Retos345_Doctor.Retos345_Doctor;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Especialidad")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

/**
 *
 * @author Usuario
 */
public class EspecialidadWeb {
    
    @Autowired
    private ServiciosEspecialidad serviciosEspecialidad;
    @GetMapping("/all")
    public List<Especialidad> getEspecialidad(){

        return serviciosEspecialidad.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Especialidad> getEspecialidad(@PathVariable("id") int id) {

        return serviciosEspecialidad.getEspecialidad(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidad save(@RequestBody Especialidad specialty) {

        return serviciosEspecialidad.save(specialty);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidad update(@RequestBody Especialidad specialty) {

        return serviciosEspecialidad.update(specialty);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {

        return serviciosEspecialidad.deleteespecialidad(id);
    }


    
}
