package desdeospring.springdesde0.models;

import java.util.Set;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="profesor")
public class Profesor implements Serializable {

    @Id
    @Column(name="idProf")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idProf;
    
    @Column (name="nombre")
    private String nombre;
    
   
    //@JsonBackReference
    /*@JoinTable(name="rel_prof_alum",
    joinColumns= @JoinColumn(name="profesor_id",referencedColumnName = "idProf"),
    inverseJoinColumns= @JoinColumn(name="alumno_id",referencedColumnName = "idAlumno"))
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)  //cascade=CascadeType.MERGE */
    @ManyToMany(mappedBy="profesores")
    //@JsonIgnore
    private List<Alumno> alumnos=new ArrayList<Alumno>();


    public Long getId() {
        return idProf;
    }

    public void setId(Long idProf) {
        this.idProf = idProf;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }
    @JsonIgnore
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void addAlumno(Alumno alumno){
        if(this.alumnos == null){
            this.alumnos = new ArrayList<Alumno>();
        }
        
        this.alumnos.add(alumno);
    }
/*
    public void addAlumno(Alumno alumno){

        if (this.alumnos==null){

            this.alumnos=new HashSet<>();
        }
        this.alumnos.add(alumno);
        
    }


 public void removeAlumno(Alumno alumno){

        if (this.alumnos==null){

            this.alumnos=new HashSet<>();
        }
        if(this.alumnos.contains(alumno))
        this.alumnos.remove(alumno);
        
    }

 */

    
}
