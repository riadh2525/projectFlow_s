package dz.corepulse.projectflow.coreApp.model.dto.response;

import dz.corepulse.projectflow.coreApp.model.enums.statuses.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDTO {

    private String name;

    private String description;

    private int progress;

    private TaskStatus status;

    private Long storyId;

    private String createdBy;

    private String updatedBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
