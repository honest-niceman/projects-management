package spring.buddy.projects.management.mappers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import spring.buddy.projects.management.dtos.ProjectDto;
import spring.buddy.projects.management.entities.Project;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {
    ProjectMapper MAPPER = Mappers.getMapper(ProjectMapper.class);

    Project projectDtoToProject(ProjectDto projectDto);

    ProjectDto projectToProjectDto(Project project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project updateProjectFromProjectDto(ProjectDto projectDto, @MappingTarget Project project);

    @AfterMapping
    default void linkTasks(@MappingTarget Project project) {
        project.getTasks()
            .forEach(task -> task.setProject(project));
    }
}
