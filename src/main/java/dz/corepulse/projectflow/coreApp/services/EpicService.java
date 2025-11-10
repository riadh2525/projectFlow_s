package dz.corepulse.projectflow.coreApp.services;

import dz.corepulse.projectflow.coreApp.model.dto.response.EpicResponse;

import java.util.List;
import java.util.Optional;

public interface EpicService {

    List<EpicResponse> getEpics();

    Optional<EpicResponse> getEpic();


}
