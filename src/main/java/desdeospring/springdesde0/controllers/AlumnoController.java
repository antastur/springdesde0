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

import desdeospring.springdesde0.models.Alumno;

import desdeospring.springdesde0.servicios.AlumnoServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

   
    private final AlumnoServicio als;
   

     public AlumnoController(AlumnoServicio als) {
        this.als = als;
    }

    //Metodo para devolver lista con objetos alumno
    @GetMapping
    public List<Alumno> servirAlumnos(){
    return  als.getAlumnos();
}

    @GetMapping("/{id}")
    public Alumno servirAlumno(@PathVariable(value = "id") Long id){
        return als.getAlumno(id);
    }


   
    @PostMapping
    public void createServAlumno(@RequestBody Alumno alumno) {
        
        als.creaAlumno(alumno);
    }
 
    @PutMapping("/{id}")
    public Alumno updateServAlumno(@PathVariable(value="id") Long id,@RequestBody Alumno alumno){

        Alumno unAlumno= this.als.getAlumno(id);
        unAlumno.setDniAlumno(alumno.getDniAlumno());
        unAlumno.setNombre(alumno.getNombre());
        unAlumno.setApellidos(alumno.getApellidos());
        unAlumno.setAsignaturas(alumno.getAsignaturas());
        final Alumno updatedAlumno=als.creaAlumno(unAlumno);
        return updatedAlumno;
    }
   
    
     @DeleteMapping("/{id}")
     public Boolean deleteServAlumno(@PathVariable(value="id") Long id){
        
          return als.borrarAlumno(id);
     }
    

}
