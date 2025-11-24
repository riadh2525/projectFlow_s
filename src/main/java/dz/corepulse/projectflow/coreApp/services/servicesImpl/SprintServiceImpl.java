package dz.corepulse.projectflow.coreApp.services.servicesImpl;

import dz.corepulse.projectflow.coreApp.mappers.SprintMapper;
import dz.corepulse.projectflow.coreApp.model.dto.request.SprintRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.SprintResponseDTO;
import dz.corepulse.projectflow.coreApp.model.entity.Sprint;
import dz.corepulse.projectflow.coreApp.model.enums.statuses.SprintStatus;
import dz.corepulse.projectflow.coreApp.repository.SprintRepo;
import dz.corepulse.projectflow.coreApp.services.SprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SprintServiceImpl implements SprintService {

    private final SprintRepo sprintRepo;
    private final SprintMapper sprintMapper;

    @Override
    public Page<SprintResponseDTO> getAllSprints(int number, int size) {
        Pageable pageable = PageRequest.of(number, size);
        return sprintRepo.findAll(pageable).map(sprintMapper::toDto);
    }

    @Override
    public SprintResponseDTO createSprint(SprintRequestDTO dto) {
        Sprint sprint = sprintMapper.toEntity(dto);
        //other code here to bring the creator
//        sprint.setCreatedBy();
        return sprintMapper.toDto(sprintRepo.save(sprint));
    }

    @Override
    public SprintResponseDTO updateSprint(Long id, SprintRequestDTO dto) {
        Sprint actual = sprintRepo.findById(id).orElseThrow(() -> new RuntimeException("Sprint with ID: "+id+" does not exist."));
        Sprint updated = sprintMapper.toEntity(dto);
        if(actual.isSame(updated)) throw new RuntimeException("Nothing to update!");
        //other code here to bring the updater
//        updated.setUpdatedBy();
        updated.setId(id);
        return sprintMapper.toDto(sprintRepo.save(updated));
    }

    @Override
    public void deleteSprint(Long id) {
        Sprint sprint = sprintRepo.findById(id).orElseThrow(() -> new RuntimeException("Spring with id "+id+" not found"));
        //other code here to bring the deleter
//        sprint.setUpdatedBy();
        sprint.setStatus(SprintStatus.ANY_1);
        sprintRepo.save(sprint);
    }
}
