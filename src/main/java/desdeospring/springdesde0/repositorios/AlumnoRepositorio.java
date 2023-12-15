package desdeospring.springdesde0.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desdeospring.springdesde0.models.Alumno;

@Repository
public interface AlumnoRepositorio  extends  JpaRepository<Alumno,Long> {

   // List<Student> findByDni
}
