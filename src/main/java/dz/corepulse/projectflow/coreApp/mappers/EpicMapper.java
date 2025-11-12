package dz.corepulse.projectflow.coreApp.mappers;

import dz.corepulse.projectflow.coreApp.model.dto.response.EpicResponse;
import dz.corepulse.projectflow.coreApp.model.entity.Epic;
import dz.corepulse.projectflow.coreApp.model.entity.Story;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
       )
public interface EpicMapper {

   @Mapping(target="storyList" ,source="storyList" ,qualifiedByName = "storyToStringList")
    EpicResponse toResponse(Epic epic);


    @Named("storyToStringList")
    default List<Long> storyToStringList(List<Story> storyList) {
        if (storyList == null) {
            return null;
        }
        return storyList.stream()
                .map(s -> s.getId())
                .toList();
    }


   @Mapping(target = "project" ,source = "project") // to do the iverse of storyToStringList
    Epic toEntity(EpicResponse  epicResponse);



}
