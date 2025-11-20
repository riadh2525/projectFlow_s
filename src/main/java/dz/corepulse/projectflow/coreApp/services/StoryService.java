package dz.corepulse.projectflow.coreApp.services;

import dz.corepulse.projectflow.coreApp.model.dto.request.StoryRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.StoryResponseDTO;
import org.springframework.data.domain.Page;

public interface StoryService {

    Page<StoryResponseDTO> getAllStories(int number, int size);

    StoryResponseDTO createStory(StoryRequestDTO storyRequestDTO);

    StoryResponseDTO updateStory(Long id, StoryRequestDTO storyRequestDTO);

    void deleteStory(Long id);
}
