package dz.corepulse.projectflow.coreApp.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SprintRequestDTO {

    private String name;

    private String description;

    private String status;

    private int progress;

    private String createdBy;

    private String updatedBy;

    private Long project;

    private List<Long> storyListIDs;

    private String goal;

    private int capacity;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
