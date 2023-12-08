package desdeospring.springdesde0.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="asignatura")
public class Asignatura {



    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(name="nombAsignatura")
    private String nombAsignatura;
    
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="alumno_id", nullable=false)
    @JsonBackReference
    private Alumno alumno;


    




    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getNombAsignatura() {
        return nombAsignatura;
    }


    public void setNombAsignatura(String nombAsignatura) {
        this.nombAsignatura = nombAsignatura;
    }

    //@JsonIgnore
    public Alumno getAlumno() {
        return alumno;
    }


    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    

   
}
