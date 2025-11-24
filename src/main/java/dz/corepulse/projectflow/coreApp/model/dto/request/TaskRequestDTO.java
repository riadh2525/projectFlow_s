package dz.corepulse.projectflow.coreApp.model.dto.request;

import dz.corepulse.projectflow.coreApp.model.entity.Story;
import dz.corepulse.projectflow.coreApp.model.enums.statuses.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDTO {

    private String name;

    private String description;

    private int progress;

    private TaskStatus status;

    private Long storyId;
}
