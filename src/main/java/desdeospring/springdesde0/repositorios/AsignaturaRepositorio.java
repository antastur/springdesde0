package desdeospring.springdesde0.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desdeospring.springdesde0.models.Asignatura;

@Repository
public interface AsignaturaRepositorio extends JpaRepository<Asignatura,Long>{

}
 