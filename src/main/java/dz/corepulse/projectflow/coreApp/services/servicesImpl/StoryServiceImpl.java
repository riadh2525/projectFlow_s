package dz.corepulse.projectflow.coreApp.services.servicesImpl;


import dz.corepulse.projectflow.coreApp.mappers.StoryMapper;
import dz.corepulse.projectflow.coreApp.model.dto.response.StoryResponse;
import dz.corepulse.projectflow.coreApp.repository.StoryRepo;
import dz.corepulse.projectflow.coreApp.services.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService {

    private final StoryRepo storyRepo;
    private final StoryMapper storyMapper ;

//    @Override
//    public List<StoryResponse> getAllStory() {
//        return storyRepo.findAll().stream()
//                .map(storyMapper::toDto)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Optional<StoryResponse> getStoryById(Long id) {
//        return Optional.empty();
//    }
}
