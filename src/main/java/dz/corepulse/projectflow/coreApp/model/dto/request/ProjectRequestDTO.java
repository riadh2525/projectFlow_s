package dz.corepulse.projectflow.coreApp.model.dto.request;

import dz.corepulse.projectflow.coreApp.model.enums.statuses.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequestDTO {

    private String name;

    private String description;

    private ProjectStatus status;

    private int progress;

    private List<Long> epicListIDs;

    private  List<Long> sprintListIDs;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
