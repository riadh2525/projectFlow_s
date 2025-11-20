package dz.corepulse.projectflow.coreApp.mappers;


import dz.corepulse.projectflow.coreApp.model.dto.request.StoryRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.StoryResponseDTO;
import dz.corepulse.projectflow.coreApp.model.entity.Epic;
import dz.corepulse.projectflow.coreApp.model.entity.Sprint;
import dz.corepulse.projectflow.coreApp.model.entity.Story;
import dz.corepulse.projectflow.coreApp.model.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;


@Mapper(componentModel = "spring")
public interface StoryMapper {

    @Mapping(source = "epicId", target = "epic", qualifiedByName = "idToEpic")
    @Mapping(source = "sprintId", target = "sprint", qualifiedByName = "idToSprint")
    @Mapping(source = "taskListIDs", target = "taskList", qualifiedByName = "idsToTasks")
    Story toEntity(StoryRequestDTO dto);

    @Mapping(source = "epic.id", target = "epicId")
    @Mapping(source = "sprint.id", target = "sprintId")
    @Mapping(source = "taskList", target = "taskListIDs", qualifiedByName = "tasksToIds")
    StoryResponseDTO toDto(Story story);

    //Helper Methods
        //toEntity
    @Named("idToEpic")
    default Epic idToEpic(Long id) {
        Epic epic = new Epic();
        epic.setId(id);
        return epic;
    }

    @Named("idToSprint")
    default Sprint idToSprint(Long id) {
        Sprint sprint = new Sprint();
        sprint.setId(id);
        return sprint;
    }

    @Named("idsToTasks")
    default List<Task> idsToTasks(List<Long> ids) {
        return ids.stream()
                .map(id -> {
                    Task task = new Task();
                    task.setId(id);
                    return task;

                })
                .toList();
    }
        //toDto
    @Named("tasksToIds")
    default List<Long> tasksToIds(List<Task> tasks) {
        return tasks.stream()
                .map(Task::getId)
                .toList();
    }
}
