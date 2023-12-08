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
import desdeospring.springdesde0.models.Asignatura;
import desdeospring.springdesde0.servicios.AsignaturaServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {


     private final AsignaturaServicio ass;
   

     public AsignaturaController(AsignaturaServicio ass) {
        this.ass = ass;
    }



     //Metodo para devolver lista con objetos asignatura
    @GetMapping
    public List<Asignatura> servirAsignaturas(){
    return  ass.getAsignaturas();
}

    @GetMapping("/{id}")
    public Asignatura servirAsignatura(@PathVariable(value = "id") Long id){
        return ass.getAsignatura(id);
    }


   
    @PostMapping
    public void createServAsignatura(@RequestBody Asignatura asignatura) {
        
        ass.creaAsignatura(asignatura);
       }
    


    @PutMapping("/{id}")
    public Asignatura updateServAsignatura(@PathVariable(value="id") Long id,Asignatura asignatura){

        Asignatura unAsignatura= this.ass.getAsignatura(id);
        unAsignatura.setNombAsignatura(asignatura.getNombAsignatura());
        unAsignatura.setAlumno(asignatura.getAlumno());
        
        final Asignatura updatedAsignatura=ass.creaAsignatura(unAsignatura);
        return updatedAsignatura;
    }
   
    
    @DeleteMapping("/{id}")
    public Boolean deleteServAsignatura(@PathVariable(value="id") Long id){
        
          return ass.borrarAsignatura(id);
    }













 














}
