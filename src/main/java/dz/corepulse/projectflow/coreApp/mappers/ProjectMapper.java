package dz.corepulse.projectflow.coreApp.mappers;

import dz.corepulse.projectflow.coreApp.model.dto.request.ProjectRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.ProjectResponseDTO;
import dz.corepulse.projectflow.coreApp.model.entity.Epic;
import dz.corepulse.projectflow.coreApp.model.entity.Project;
import dz.corepulse.projectflow.coreApp.model.entity.Sprint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(source = "epicListIDs", target = "epicList", qualifiedByName = "IDsToEpics")
    @Mapping(source = "sprintListIDs", target = "sprintList", qualifiedByName = "IDsToSprints")
    Project toEntity(ProjectRequestDTO dto);

    @Mapping(source = "epicList", target = "epicListIDs", qualifiedByName = "epicsToIDs")
    @Mapping(source = "sprintList", target = "sprintListIDs", qualifiedByName = "sprintsToIDs")
    ProjectResponseDTO toDto(Project project);

    //Helper Methods
        //toEntity
    @Named("IDsToEpics")
    default List<Epic> IDsToEpics(List<Long> ids) {
        if (ids == null) return null;
        return ids.stream()
                .map(id -> {
                    Epic epic = new Epic();
                    epic.setId(id);
                    return epic;
                })
                .toList();
    }

    @Named("IDsToSprints")
    default List<Sprint> IDsToSprints(List<Long> ids) {
        if (ids == null) return null;
        return ids.stream()
                .map(id -> {
                    Sprint sprint = new Sprint();
                    sprint.setId(id);
                    return sprint;
                })
                .toList();
    }

        //toDto
    @Named("epicsToIDs")
    default List<Long> epicsToIDs(List<Epic> epics) {
        if (epics == null) return null;
        return epics.stream()
                .map(Epic::getId)
                .toList();
    }

    @Named("sprintsToIDs")
    default List<Long> sprintsToIDs(List<Sprint> sprints) {
        if (sprints == null) return null;
        return sprints.stream()
                .map(Sprint::getId)
                .toList();
    }
}
