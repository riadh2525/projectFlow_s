package dz.corepulse.projectflow.coreApp.services.servicesImpl;

//import dz.corepulse.projectflow.coreApp.mappers.EpicMapper;
import dz.corepulse.projectflow.coreApp.model.dto.response.EpicResponse;
import dz.corepulse.projectflow.coreApp.repository.EpicRepo;
import dz.corepulse.projectflow.coreApp.services.EpicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EpicServiceImpl implements EpicService {

//private final EpicRepo epicRepo;
//private final EpicMapper epicMapper;
//
//    @Override
//    public List<EpicResponse> getEpics() {
//        return epicRepo.findAll().stream()
//                .map(epicMapper::toResponse)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Optional<EpicResponse> getEpic(Long id) {
//        return Optional.empty();
//    }


}
