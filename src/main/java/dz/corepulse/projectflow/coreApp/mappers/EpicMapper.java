package dz.corepulse.projectflow.coreApp.mappers;

import dz.corepulse.projectflow.coreApp.model.dto.request.EpicRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.EpicResponseDTO;
import dz.corepulse.projectflow.coreApp.model.entity.Epic;
import dz.corepulse.projectflow.coreApp.model.entity.Project;
import dz.corepulse.projectflow.coreApp.model.entity.Story;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EpicMapper {

    @Mapping(source = "projectId", target = "project", qualifiedByName = "idToProject")
    @Mapping(source = "storyListIDs", target = "storyList", qualifiedByName = "idsToStories")
    Epic toEntity(EpicRequestDTO dto);

    @Mapping(source = "project.id", target = "projectId")
    @Mapping(source = "storyList", target = "storyListIDs", qualifiedByName = "storiesToIDs")
    EpicResponseDTO toDto(Epic epic);

    //Helper methods
    //toEntity
    @Named("idToProject")
    default Project idToProject(Long id) {
        Project project = new Project();
        project.setId(id);
        return project;
    }

    @Named("idsToStories")
    default List<Story> idsToStories(List<Long> ids) {
        if (ids == null) return null;
        return ids.stream()
                .map(id -> {
                    Story story = new Story();
                    story.setId(id);
                    return story;
                })
                .toList();
    }

        //toDto
    @Named("storiesToIDs")
    default List<Long> storiesToIDs(List<Story> storyList) {
        return storyList.stream()
                .map(Story::getId)
                .toList();
    }
}
