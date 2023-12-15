package desdeospring.springdesde0.models;


import java.util.Set;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/*@JsonIdentityInfo(
   generator = ObjectIdGenerators.PropertyGenerator.class,
   property = "idAlumno")
@JsonIdentityReference(alwaysAsId = true) */ 
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="alumno")
public class Alumno implements Serializable{

    @Id
    @Column(name="idAlumno")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idAlumno;
    @Column(name="dniAlumno")
    private String dniAlumno;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellidos")
    private String apellidos;
    @JsonManagedReference
    @OneToMany(mappedBy="alumno",cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Asignatura> asignaturas;
    
  
    //@JsonManagedReference
    @JoinTable(name="rel_prof_alum",
    joinColumns= @JoinColumn(name="alumno_id",referencedColumnName = "idAlumno"),
    inverseJoinColumns= @JoinColumn(name="profesor_id",referencedColumnName = "idProf"))
    @ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.EAGER) //cascadetype merge 
    //@ManyToMany(mappedBy="alumnos" ,cascade=CascadeType.ALL) 
    private List<Profesor> profesores=new  ArrayList<Profesor>();
   
   
    public Alumno(String dniAlumno, String nombre, String apellidos) {
        this.dniAlumno = dniAlumno;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }


    public long getId() {
        return idAlumno;
    }
    public void setId(long idAlumno) {
        this.idAlumno= idAlumno;
    } 
    public String getDniAlumno() {
        return dniAlumno;
    }
    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
   

     public Set<Asignatura> getAsignaturas() {
        return asignaturas;
    }
    public void setAsignaturas(Set<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }


      public List<Profesor> getProfesores() {
        return profesores;
    }
    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public void addProfesor(Profesor profesor){
        if(this.profesores == null){
            this.profesores = new ArrayList<Profesor>();
        }
        
        this.profesores.add(profesor);
    }
    
/*
    public void addAsignatura(Asignatura asignatura){
        if(this.asignaturas==null){
            this.asignaturas=new HashSet<>();
        }
        asignaturas.add(asignatura);
        asignatura.setAlumno(this);
    }

    public void removeAsignatura(Asignatura asignatura){
        if(this.asignaturas==null){
            this.asignaturas=new HashSet<>();
        }
        if(this.asignaturas.contains(asignatura))
        asignaturas.remove(asignatura);
        asignatura.setAlumno(this);
    }


     public void addProfesor(Profesor profesor){

        if (this.profesores==null){

            this.profesores=new HashSet<>();
        }
        this.profesores.add(profesor);
        this.setProfesores(this.profesores);
    }


 public void removeProfesor(Profesor profesor){

        if (this.profesores==null){

            this.profesores=new HashSet<>();
        }
        if(this.profesores.contains(profesor))
        this.profesores.remove(profesor);
        this.setProfesores(this.profesores);
    }

 */
   
}
