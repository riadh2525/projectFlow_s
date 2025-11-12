package dz.corepulse.projectflow.coreApp.model.dto.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class StoryResponse {

    private long id ;

    private String name ;

    private String description ;

    private String status ;

    private int progress ;

    private String createdBy;

    private String updatedBy;

    private LocalDateTime createdAt ;

    private LocalDateTime updatedAt ;

    private Long epic ;

    private Long sprint ;

    private List<Long> taskList ;

}
