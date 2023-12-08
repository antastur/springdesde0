package desdeospring.springdesde0;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import desdeospring.springdesde0.models.Alumno;
import desdeospring.springdesde0.models.Asignatura;
import desdeospring.springdesde0.repositorios.AlumnoRepositorio;
import desdeospring.springdesde0.repositorios.AsignaturaRepositorio;
import desdeospring.springdesde0.servicios.AlumnoServicio;

@Component
public class MyRunner implements CommandLineRunner {

     private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

       private final AlumnoRepositorio als;
       private final AsignaturaRepositorio ags;

      public MyRunner(AlumnoRepositorio als,AsignaturaRepositorio ags) {
        this.als=als;
        this.ags=ags;
      }

    @Override
    public void run(String... args) throws Exception {
      
     Alumno pedro =new Alumno();
		 pedro.setDniAlumno("17362522o");
     pedro.setNombre("Pedro");
     pedro.setApellidos("Canelo Gomez");
     
     
     

     Alumno antonio =new Alumno();
		 antonio.setDniAlumno("11422613p");
     antonio.setNombre("Antonio");
     antonio.setApellidos("Marquina Barrachina");
     
     Set<Asignatura> asignaturasa= new HashSet<Asignatura>();
		 Set<Asignatura> asignaturasp= new HashSet<Asignatura>();
      
      Asignatura religiona=new Asignatura();
      religiona.setNombAsignatura("religion");
      religiona.setAlumno(antonio);
      
      Asignatura historiaa=new Asignatura();
      historiaa.setNombAsignatura("historia");
      historiaa.setAlumno(antonio);
      
      Asignatura religionp=new Asignatura();
      religionp.setNombAsignatura("religion");
      religionp.setAlumno(pedro);
      
      asignaturasa.add(religiona);
      asignaturasa.add(historiaa);
      antonio.setAsignaturas(asignaturasa); 
      
      asignaturasp.add(religionp);
      pedro.setAsignaturas(asignaturasp);
      
      als.save(pedro);
      als.save(antonio);

//ags.save(religion);

    }
      

}
