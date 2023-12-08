package desdeospring.springdesde0.servicios;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import desdeospring.springdesde0.models.Alumno;
import desdeospring.springdesde0.models.Asignatura;
import desdeospring.springdesde0.repositorios.AlumnoRepositorio;
import desdeospring.springdesde0.repositorios.AsignaturaRepositorio;


@Service
public class AlumnoServicio {

    final AlumnoRepositorio alr;
    final AsignaturaRepositorio asr;
    AlumnoServicio(AlumnoRepositorio alr,AsignaturaRepositorio asr) {
        this.alr = alr;
        this.asr=asr;
    }



//Servicio para obtener una lista de alumnos
   public List<Alumno> getAlumnos(){
       
        List<Alumno> alumnos=this.alr.findAll();
        return alumnos;
    }


//para obtener un alumno
public Alumno  getAlumno(Long id){
  
         Optional <Alumno> op= this.alr.findById(id);
         Alumno al=null;
            if(op.isPresent()){
                al=op.get();
                return al;
            }else{
                return null;
            }

}


//Servicio para guardar un alumno
public Alumno creaAlumno(@RequestBody Alumno alumno){
        

        return this.alr.save(alumno);
        

    }

    

//para modificar un alumno
public Alumno cambiarAlumno(Alumno request,Long id){

    Alumno al=this.alr.findById(id).get();
    al.setDniAlumno(request.getDniAlumno());
    al.setNombre(request.getNombre());
    al.setApellidos(request.getApellidos());
    Set<Asignatura> asignaturas =al.getAsignaturas();
    
    for (Asignatura asig : asignaturas){
        asr.delete(asig);
    }

    al.setAsignaturas(request.getAsignaturas());
  Alumno updatedAl=this.alr.save(al);
    return updatedAl;
}


//para borrar un alumno
public Boolean borrarAlumno(Long id){
    Alumno al;
    Boolean borrado=true;
    Optional<Alumno> oal=this.alr.findById(id);
    if(oal.isPresent())
    try{
        al=oal.get();
        this.alr.delete(al);

    }catch(Exception e){
        borrado=false;
    }
    return borrado;
}







}
