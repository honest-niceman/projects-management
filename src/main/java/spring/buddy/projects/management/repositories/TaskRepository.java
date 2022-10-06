package spring.buddy.projects.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.buddy.projects.management.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
