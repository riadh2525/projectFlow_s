package dz.corepulse.projectflow.coreApp.model.dto.request;

import dz.corepulse.projectflow.coreApp.model.enums.statuses.EpicStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpicRequestDTO {

    private String name;

    private String description;

    private int progress;

    private EpicStatus status;

    private List<Long> storyListIDs;

    private Long projectId;
}
