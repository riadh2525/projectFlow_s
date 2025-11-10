package dz.corepulse.projectflow.coreApp.model.dto.response;




import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data

public class EpicResponse {


    private List<Long> story ;

    private Long project;

}
