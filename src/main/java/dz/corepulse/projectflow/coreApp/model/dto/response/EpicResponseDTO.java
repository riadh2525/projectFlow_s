package dz.corepulse.projectflow.coreApp.model.dto.response;

import dz.corepulse.projectflow.coreApp.model.enums.statuses.EpicStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpicResponseDTO {

    private String name ;

    private String description ;

    private EpicStatus status ;

    private int progress ;

    private String createdBy;

    private String updatedBy;

    private LocalDateTime createdAt ;

    private LocalDateTime updatedAt ;

    private List<Long> storyListIDs ;

    private Long projectId;
}
