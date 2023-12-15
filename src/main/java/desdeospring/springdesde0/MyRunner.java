package desdeospring.springdesde0;

import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import desdeospring.springdesde0.models.Alumno;
import desdeospring.springdesde0.models.Asignatura;
import desdeospring.springdesde0.models.Profesor;
import desdeospring.springdesde0.repositorios.AlumnoRepositorio;
import desdeospring.springdesde0.repositorios.AsignaturaRepositorio;
import desdeospring.springdesde0.repositorios.ProfesorRepositorio;


@Component
public class MyRunner implements CommandLineRunner {

     private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

       private final AlumnoRepositorio als;
       private final AsignaturaRepositorio ags;
       private final ProfesorRepositorio prr;

      public MyRunner(AlumnoRepositorio als,AsignaturaRepositorio ags,ProfesorRepositorio prr) {
        this.als=als;
        this.ags=ags;
        this.prr=prr;
      }

    @Override
    public void run(String... args) throws Exception {
      
     Alumno pedro =new Alumno();
		 pedro.setDniAlumno("17362522p");
     pedro.setNombre("Pedro");
     pedro.setApellidos("Canelo Gomez");
     
     
     

     Alumno antonio =new Alumno();
		 antonio.setDniAlumno("11422613L");
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
      
    /* 

      als.save(pedro);
      als.save(antonio);

     
      
     
      
      
       Profesor andres=new Profesor();
       andres.setName("Andres");
       andres.addAlumno(antonio);
       andres.addAlumno(pedro);

      prr.save(andres);
   
*/
     Profesor andres=new Profesor();
       andres.setName("Andres");
       andres.addAlumno(antonio);
       andres.addAlumno(pedro);


     Profesor mateo=new Profesor();
     mateo.setName("Mateo");
     mateo.addAlumno(antonio);
     Profesor agustin=new Profesor();
     agustin.setName("Agustin");
     agustin.addAlumno(pedro);
    
    antonio.addProfesor(agustin);
    antonio.addProfesor(mateo);
    pedro.addProfesor(agustin);


    
  

    prr.save(andres);
    prr.save(mateo);
    prr.save(agustin);


     

    
     als.save(pedro);
    als.save(antonio);


    
    
    
     
   

    

    

    
    
    
   


    }
      

}
