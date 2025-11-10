package dz.corepulse.projectflow.coreApp.mapper;

import dz.corepulse.projectflow.coreApp.model.dto.response.EpicResponse;
import dz.corepulse.projectflow.coreApp.model.entity.Epic;
import org.mapstruct.ReportingPolicy;
//import org.springframework.web.bind.annotation.Mapping;
import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE

)
public interface EpicMapper {


//    @Mapping(target="project" ,source="project")
    EpicResponse toResponse(Epic epic);

    Epic toEntity(EpicResponse  epicResponse);

}
