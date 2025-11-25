package dz.corepulse.projectflow.coreApp.services;

import dz.corepulse.projectflow.coreApp.model.dto.request.StoryRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.StoryResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

public interface StoryService {

    Page<StoryResponseDTO> getAllStories(int number, int size);

    StoryResponseDTO getStoryById(Long id);

    StoryResponseDTO createStory(StoryRequestDTO storyRequestDTO);

    StoryResponseDTO updateStory(Long id, StoryRequestDTO storyRequestDTO);

    void deleteStory(Long id);
}
