package spring.buddy.projects.management.dtos;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link spring.buddy.projects.management.entities.Task} entity
 */
public class TaskDto implements Serializable {
    private final Long id;
    private final String name;
    private final OffsetDateTime startDate;
    private final OffsetDateTime endDate;

    public TaskDto(Long id, String name, OffsetDateTime startDate, OffsetDateTime endDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TaskDto entity = (TaskDto) o;
        return Objects.equals(this.id, entity.id) &&
            Objects.equals(this.name, entity.name) &&
            Objects.equals(this.startDate, entity.startDate) &&
            Objects.equals(this.endDate, entity.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, endDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
            "id = " + id + ", " +
            "name = " + name + ", " +
            "startDate = " + startDate + ", " +
            "endDate = " + endDate + ")";
    }
}
