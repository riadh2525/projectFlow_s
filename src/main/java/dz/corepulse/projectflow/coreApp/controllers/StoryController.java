package dz.corepulse.projectflow.coreApp.controllers;

import dz.corepulse.projectflow.coreApp.model.dto.request.StoryRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.StoryResponseDTO;
import dz.corepulse.projectflow.coreApp.services.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coreapp/story")
@RequiredArgsConstructor
public class StoryController {

    private final StoryService storyService;

    @GetMapping("/all-stories")
    public ResponseEntity<Page<StoryResponseDTO>> getAllStories(@RequestParam int number,
                                                                @RequestParam int size) {
        return ResponseEntity.ok(storyService.getAllStories(number, size));
    }

    @GetMapping("/story-by-id")
    public ResponseEntity<StoryResponseDTO> getStoryById(@RequestParam long id) {
        return ResponseEntity.ok(storyService.getStoryById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<StoryResponseDTO> createStory(@RequestBody StoryRequestDTO storyRequestDTO) {
        return ResponseEntity.ok(storyService.createStory(storyRequestDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<StoryResponseDTO> updateStory(@RequestParam Long id,
                                                        @RequestBody StoryRequestDTO storyRequestDTO) {
        return ResponseEntity.ok(storyService.updateStory(id, storyRequestDTO));
    }

    @DeleteMapping("/delete")
    public void deleteStory(@RequestParam Long id) {
        storyService.deleteStory(id);
    }
}
