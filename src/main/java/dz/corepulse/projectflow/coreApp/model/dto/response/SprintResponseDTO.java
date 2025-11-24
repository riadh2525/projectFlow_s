package dz.corepulse.projectflow.coreApp.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SprintResponseDTO {

    private String name;

    private String description;

    private String status;

    private int progress;

    private String createdBy;

    private String updatedBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long projectId;

    private List<Long> storyListIDs;

    private String goal;

    private int capacity;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
