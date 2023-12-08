package desdeospring.springdesde0.servicios;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import desdeospring.springdesde0.models.Alumno;
import desdeospring.springdesde0.models.Asignatura;
import desdeospring.springdesde0.models.Profesor;
import desdeospring.springdesde0.repositorios.AlumnoRepositorio;
import desdeospring.springdesde0.repositorios.AsignaturaRepositorio;
import desdeospring.springdesde0.repositorios.ProfesorRepositorio;

@Service
public class ProfesorServicio {

AlumnoRepositorio alumnoRep;
AsignaturaRepositorio asignRep;
ProfesorRepositorio profRep;

ProfesorServicio(AlumnoRepositorio alumnoRep,AsignaturaRepositorio asignRep,ProfesorRepositorio profRep){

    this.alumnoRep=alumnoRep;
    this.asignRep=asignRep;
    this.profRep=profRep;

}


//Servicio para obtener una lista de profesores
   public List<Profesor> getProfesores(){
       
        List<Profesor> profesores=this.profRep.findAll();
        return profesores;
    }


//para obtener un profesor
public Profesor  getProfesor(Long id){
  
         Optional <Profesor> op= this.profRep.findById(id);
         Profesor prof=null;
            if(op.isPresent()){
                prof=op.get();
                return prof;
            }else{
                return null;
            }

}


//Servicio para guardar un profesor
public Profesor creaProfesor(@RequestBody Profesor profesor){
        

        return this.profRep.save(profesor);
        

    }


 

    //para modificar un profesor
public Profesor cambiarProfesor(Profesor request,Long id){

    Profesor prof=this.profRep.findById(id).get();
    prof.setName(request.getName());//setDniAlumno(request.getDniAlumno());
    prof.setAlumnos(request.getAlumnos());
    Set<Alumno> alumnos = prof.getAlumnos();
    
    for (Alumno alum : alumnos){
        alumnoRep.delete(alum);
    }

    prof.setAlumnos(request.getAlumnos());

    Profesor updatedProf=this.profRep.save(prof);
    return updatedProf;
}




//para borrar un profesor
public Boolean borrarProfesor(Long id){
    Profesor prof;
    Boolean borrado=true;
    Optional<Profesor> opProf=this.profRep.findById(id);
    if(opProf.isPresent())
    try{
        prof=opProf.get();
        this.profRep.delete(prof);

    }catch(Exception e){
        borrado=false;
    }
    return borrado;
}







}
