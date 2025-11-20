package dz.corepulse.projectflow.coreApp.services;

import dz.corepulse.projectflow.coreApp.model.dto.request.EpicRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.EpicResponseDTO;
import org.springframework.data.domain.Page;

public interface EpicService {

    //Basic CRUD operations
    Page<EpicResponseDTO> getAllEpics(int number, int size);

    EpicResponseDTO createEpic(EpicRequestDTO epicRequestDTO);

    EpicResponseDTO updateEpic(Long id, EpicRequestDTO epicRequestDTO);

    void deleteEpic(Long id);

    //others
}
