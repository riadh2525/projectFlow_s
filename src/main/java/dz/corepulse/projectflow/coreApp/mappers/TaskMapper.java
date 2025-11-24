package dz.corepulse.projectflow.coreApp.mappers;

import dz.corepulse.projectflow.coreApp.model.dto.request.TaskRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.TaskResponseDTO;
import dz.corepulse.projectflow.coreApp.model.entity.Story;
import dz.corepulse.projectflow.coreApp.model.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(source = "storyId", target = "story", qualifiedByName = "idToStory")
    Task toEntity(TaskRequestDTO taskRequestDTO);

    @Mapping(source = "story.id", target = "storyId")
    TaskResponseDTO toDto(Task  task);

    //Helper Methods
        //toEntity
    @Named("idToStory")
    default Story toStory(Long id) {
        Story story = new Story();
        story.setId(id);
        return story;
    }
}
