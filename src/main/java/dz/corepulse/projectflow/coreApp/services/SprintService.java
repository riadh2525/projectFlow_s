package dz.corepulse.projectflow.coreApp.services;

import dz.corepulse.projectflow.coreApp.model.dto.request.SprintRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.SprintResponseDTO;

public interface SprintService {

    SprintResponseDTO createSprint(SprintRequestDTO dto);
}
