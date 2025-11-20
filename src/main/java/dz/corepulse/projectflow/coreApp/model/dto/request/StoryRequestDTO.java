package dz.corepulse.projectflow.coreApp.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoryRequestDTO {

    private String name ;

    private String description ;

    private String status ;

    private int progress ;

    private String updatedBy;

    private Long epicId ;

    private Long sprintId ;

    private List<Long> taskListIDs ;
}
