package desdeospring.springdesde0.models;


import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="dniAlumno")
    private String dniAlumno;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellidos")
    private String apellidos;
    @OneToMany(mappedBy="alumno",cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonManagedReference
    private Set<Asignatura> asignaturas;
    @ManyToMany(mappedBy="alumnos",cascade=CascadeType.ALL)
    private Set<Profesor> profesores;
   
   
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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

    public void addAsignatura(Asignatura asignatura){
        asignaturas.add(asignatura);
        asignatura.setAlumno(this);
    }

    public void removeAsignatura(Asignatura asignatura){
        asignaturas.remove(asignatura);
        asignatura.setAlumno(this);
    }



}
