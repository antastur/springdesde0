package desdeospring.springdesde0.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import desdeospring.springdesde0.models.Profesor;
import desdeospring.springdesde0.servicios.ProfesorServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    
      private final ProfesorServicio profServ;
   

     public ProfesorController(ProfesorServicio profServ) {
        this.profServ = profServ;
    }


     //Metodo para devolver lista con objetos alumno
    @GetMapping
    public List<Profesor> servirProfesores(){
    return  profServ.getProfesores();
}


     @GetMapping("/{id}")
    public Profesor servirProfesor(@PathVariable(value = "id") Long id){
        return profServ.getProfesor(id);
    }


     @PostMapping
    public void createServProfesor(@RequestBody Profesor profesor) {
        
       profServ.creaProfesor(profesor);
    }
 

     @PutMapping("/{id}")
    public Profesor updateServProfesor(@PathVariable(value="id") Long id,@RequestBody Profesor profesor){

        Profesor unProfesor= this.profServ.getProfesor(id);
        unProfesor.setName(profesor.getName());
        unProfesor.setAlumnos(profesor.getAlumnos());
        
        final Profesor updatedProfesor=profServ.creaProfesor(unProfesor);
        return updatedProfesor;
    }


         @DeleteMapping("/{id}")
     public Boolean deleteServProfesor(@PathVariable(value="id") Long id){
        
          return profServ.borrarProfesor(id);
     }
}
