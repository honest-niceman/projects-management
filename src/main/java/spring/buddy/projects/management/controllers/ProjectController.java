package spring.buddy.projects.management.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import spring.buddy.projects.management.dtos.ProjectDto;
import spring.buddy.projects.management.entities.Project;
import spring.buddy.projects.management.mappers.ProjectMapper;
import spring.buddy.projects.management.services.ProjectService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/project-management")
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectMapper projectMapper;

    public ProjectController(ProjectService projectService,
                             ProjectMapper projectMapper) {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
    }

    @GetMapping("/projects/{name}")
    @Secured({"ROLE_MANAGER", "ROLE_ADMIN", "ROLE_USER"})
    public List<ProjectDto> findProjectsByName(@PathVariable String name) {
        return projectService.findByName(name)
            .stream()
            .map(projectMapper::projectToProjectDto)
            .collect(Collectors.toList());
    }

    @PostMapping("/project")
    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    public ProjectDto createProject(@RequestBody @NonNull ProjectDto projectDto) {
        if (projectDto.getId() != null) {
            throw new IllegalArgumentException("New project should not contain value for the id field");
        }
        Project entity = projectMapper.projectDtoToProject(projectDto);
        return projectMapper.projectToProjectDto(projectService.save(entity));
    }

    @DeleteMapping("/project/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Long> deleteProject(@PathVariable Long id) {
        projectService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
