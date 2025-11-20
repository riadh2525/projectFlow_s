package dz.corepulse.projectflow.coreApp.model.dto.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class StoryResponseDTO {

    private String name;

    private String description;

    private String status;

    private int progress;

    private String createdBy;

    private String updatedBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long epicId;

    private Long sprintId;

    private List<Long> taskListIDs;

}
