package dz.corepulse.projectflow.coreApp.services;

import dz.corepulse.projectflow.coreApp.model.dto.request.SprintRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.SprintResponseDTO;
import org.springframework.data.domain.Page;

public interface SprintService {

    Page<SprintResponseDTO> getAllSprints(int number, int size);

    SprintResponseDTO createSprint(SprintRequestDTO dto);

    SprintResponseDTO updateSprint(Long id, SprintRequestDTO dto);

    void deleteSprint(Long id);
}
