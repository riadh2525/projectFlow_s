package dz.corepulse.projectflow.coreApp.services.servicesImpl;

import dz.corepulse.projectflow.coreApp.mappers.EpicMapper;
import dz.corepulse.projectflow.coreApp.model.dto.request.EpicRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.EpicResponseDTO;
import dz.corepulse.projectflow.coreApp.model.entity.Epic;
import dz.corepulse.projectflow.coreApp.model.enums.statuses.EpicStatus;
import dz.corepulse.projectflow.coreApp.repository.EpicRepo;
import dz.corepulse.projectflow.coreApp.services.EpicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EpicServiceImpl implements EpicService {

    private final EpicRepo epicRepo;
    private final EpicMapper epicMapper;

    @Override
    public Page<EpicResponseDTO> getAllEpics(int number, int size) {
        Pageable pageable = PageRequest.of(number, size);
        return epicRepo.findAll(pageable).map(epicMapper::toDto);
    }

    @Override
    public EpicResponseDTO createEpic(EpicRequestDTO epicRequestDTO) {
        return epicMapper.toDto(epicRepo.save(epicMapper.toEntity(epicRequestDTO)));
    }

    @Override
    public EpicResponseDTO updateEpic(Long id, EpicRequestDTO epicRequestDTO) {
        Epic actual = epicRepo.findById(id).orElseThrow(() -> new RuntimeException("Epic with id " + id + " not found"));
        Epic updated = epicMapper.toEntity(epicRequestDTO);
        if(actual.equals(updated)) throw  new RuntimeException("Nothing to update!");
        updated.setId(id);
        return epicMapper.toDto(epicRepo.save(updated));
    }

    @Override
    public void deleteEpic(Long id) {
        Epic epic = epicRepo.findById(id).orElseThrow(() -> new RuntimeException("Epic with id " + id + " not found"));
        epic.setStatus(EpicStatus.ANY_1);
    }
}
