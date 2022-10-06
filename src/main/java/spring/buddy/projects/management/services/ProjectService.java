package spring.buddy.projects.management.services;

import org.springframework.stereotype.Service;
import spring.buddy.projects.management.entities.Project;
import spring.buddy.projects.management.repositories.ProjectRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findByName(String name) {
        return projectRepository.findByName(name);
    }

    public Project save(Project entity) {
        return projectRepository.save(entity);
    }

    public void deleteById(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new EntityNotFoundException("Entity with id=%d was not found".formatted(id));
        }
        projectRepository.deleteById(id);
    }
}
