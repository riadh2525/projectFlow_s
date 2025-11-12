package dz.corepulse.projectflow.coreApp.services;


import dz.corepulse.projectflow.coreApp.model.dto.response.StoryResponse;

import java.util.List;
import java.util.Optional;

public interface StoryService {

    List<StoryResponse> getAllStory();

    Optional<StoryResponse> getStoryById(Long id);
    }
