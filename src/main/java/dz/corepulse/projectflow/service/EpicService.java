package dz.corepulse.projectflow.service;

import dz.corepulse.projectflow.model.dto.response.EpicResponse;

import java.util.List;
import java.util.Optional;

public interface EpicService {

    List<EpicResponse> getEpics();

    Optional<EpicResponse> getEpic();


}
