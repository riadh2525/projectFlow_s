package dz.corepulse.projectflow.coreApp.mappers;

import dz.corepulse.projectflow.coreApp.model.dto.request.SprintRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.SprintResponseDTO;
import dz.corepulse.projectflow.coreApp.model.entity.Project;
import dz.corepulse.projectflow.coreApp.model.entity.Sprint;
import dz.corepulse.projectflow.coreApp.model.entity.Story;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface SprintMapper {

    @Mapping(source = "project.id", target = "projectId")
    @Mapping(source = "storyList", target = "storyListIDs", qualifiedByName = "storiesToIDs")
    SprintResponseDTO toDto(Sprint sprint);

    @Mapping(source = "projectId", target = "project", qualifiedByName = "idToProject")
    @Mapping(source = "storyListIDs", target = "storyList", qualifiedByName = "idsToStories")
    Sprint toEntity(SprintRequestDTO dto);

    //Helper Methods
    //toDTO
    @Named("storiesToIDs")
    default List<Long> storiesToIDs(List<Story> stories) {
        return stories.stream()
                .map(Story::getId)
                .collect(Collectors.toList());
    }

    //toEntity
    @Named("idToProject")
    default Project  idToProject(Long projectId) {
        Project project = new Project();
        project.setId(projectId);
        return project;
    }

    @Named("idsToStories")
    default List<Story> idsToStories(List<Long> ids) {
        return ids.stream()
                .map(id -> {
                    Story story = new Story();
                    story.setId(id);
                    return story;
                })
                .collect(Collectors.toList());
    }
}
