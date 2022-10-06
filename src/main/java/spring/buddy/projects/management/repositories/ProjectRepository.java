package spring.buddy.projects.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.buddy.projects.management.entities.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("select p from Project p where p.name = ?1")
    List<Project> findByName(String name);
}
