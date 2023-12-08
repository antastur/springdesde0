package desdeospring.springdesde0.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import desdeospring.springdesde0.models.Alumno;
import desdeospring.springdesde0.models.Asignatura;
import desdeospring.springdesde0.repositorios.AlumnoRepositorio;
import desdeospring.springdesde0.repositorios.AsignaturaRepositorio;

@Service
public class AsignaturaServicio {


     final AsignaturaRepositorio asr;
    AsignaturaServicio(AsignaturaRepositorio asr) {
        this.asr = asr;
    }


    //Servicio para obtener una lista de alumnos
    public List<Asignatura> getAsignaturas(){
       
        List<Asignatura> asignaturas=this.asr.findAll();
        return asignaturas;
    }


    //para obtener un alumno
    public Asignatura  getAsignatura(Long id){
  
         Optional <Asignatura> op= this.asr.findById(id);
         Asignatura as=null;
            if(op.isPresent()){
                as=op.get();
                return as;
            }else{
                return null;
            }
    }


    //Servicio para guardar un alumno
    public Asignatura creaAsignatura(@RequestBody Asignatura asignatura){
        
        return this.asr.save(asignatura);
        
    }


    //para modificar un alumno
    public Asignatura cambiarAsignatura(Asignatura request,Long id){

        Asignatura as=this.asr.findById(id).get();
        as.setNombAsignatura(request.getNombAsignatura());
        as.setAlumno(request.getAlumno());
        
        Asignatura updatedAs=this.asr.save(as);
        return updatedAs;
    }


    //para borrar un alumno
    public Boolean borrarAsignatura(Long id){
    Asignatura as;
    Boolean borrado=true;
    Optional<Asignatura> oal=this.asr.findById(id);
    if(oal.isPresent())
    try{
        as=oal.get();
        this.asr.delete(as);

    }catch(Exception e){
        borrado=false;
    }
    return borrado;
}

















}
