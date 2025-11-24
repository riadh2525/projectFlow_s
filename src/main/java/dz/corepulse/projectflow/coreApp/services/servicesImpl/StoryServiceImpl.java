package dz.corepulse.projectflow.coreApp.services.servicesImpl;


import dz.corepulse.projectflow.coreApp.mappers.StoryMapper;
import dz.corepulse.projectflow.coreApp.model.dto.request.StoryRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.StoryResponseDTO;
import dz.corepulse.projectflow.coreApp.model.entity.Story;
import dz.corepulse.projectflow.coreApp.model.enums.statuses.StoryStatus;
import dz.corepulse.projectflow.coreApp.repository.StoryRepo;
import dz.corepulse.projectflow.coreApp.services.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService {

    private final StoryRepo storyRepo;
    private final StoryMapper storyMapper ;


    @Override
    public Page<StoryResponseDTO> getAllStories(int number, int size) {
        Pageable pageable = PageRequest.of(number, size);
        return storyRepo.findAll(pageable).map(storyMapper::toDto);
    }

    @Override
    public StoryResponseDTO createStory(StoryRequestDTO storyRequestDTO) {
        Story story = storyMapper.toEntity(storyRequestDTO);
        //other code here to bring the creator
//        story.setCreatedBy();
        return storyMapper.toDto(story);
    }

    @Override
    public StoryResponseDTO updateStory(Long id, StoryRequestDTO storyRequestDTO) {
        Story actual = storyRepo.findById(id).orElseThrow(() -> new RuntimeException("Story with id " + id + " not found"));
        Story updated = storyMapper.toEntity(storyRequestDTO);
        if (actual.isSame(updated)) throw new RuntimeException("Story with id " + id + " already exists");
        //other code here to bring the updater
//        updated.setUpdatedBy();
        updated.setId(id);
        return storyMapper.toDto(storyRepo.save(updated));
    }

    @Override
    public void deleteStory(Long id) {
        Story story = storyRepo.findById(id).orElseThrow(() -> new RuntimeException("Story with id " + id + " not found"));
        //other code here to bring the deleter
//        sprint.setUpdatedBy();
        story.setStatus(StoryStatus.ANY_1);
        storyRepo.save(story);
    }
}
