package dz.corepulse.projectflow.coreApp.services.servicesImpl;

import dz.corepulse.projectflow.coreApp.mappers.SprintMapper;
import dz.corepulse.projectflow.coreApp.model.dto.request.SprintRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.SprintResponseDTO;
import dz.corepulse.projectflow.coreApp.repository.SprintRepo;
import dz.corepulse.projectflow.coreApp.services.SprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SprintServiceImpl implements SprintService {

    private final SprintRepo sprintRepo;
    private final SprintMapper sprintMapper;

    @Override
    public SprintResponseDTO createSprint(SprintRequestDTO dto) {
        return sprintMapper.toDto(sprintRepo.save(sprintMapper.toEntity(dto)));
    }
}
