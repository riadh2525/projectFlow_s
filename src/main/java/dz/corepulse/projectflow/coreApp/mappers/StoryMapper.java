package dz.corepulse.projectflow.coreApp.mappers;


import dz.corepulse.projectflow.coreApp.model.dto.response.StoryResponse;
import dz.corepulse.projectflow.coreApp.model.entity.Story;
import dz.corepulse.projectflow.coreApp.model.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring" ,
        unmappedTargetPolicy = ReportingPolicy.IGNORE) //
public interface StoryMapper {

    @Mapping(target = "taskList" ,source = "taskList")
    StoryResponse  toDto(Story story);


    @Named("TaskToStringList")
    default List<Long> TaskToStringList(List<Task> taskList){
        if(taskList == null){
           return null ;
        }
     return  taskList.stream()
             .map(task -> task.getId())
             .toList();
    }

    Story toEntity(StoryResponse req);

}
