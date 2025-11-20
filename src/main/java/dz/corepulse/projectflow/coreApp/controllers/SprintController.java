package dz.corepulse.projectflow.coreApp.controllers;

import dz.corepulse.projectflow.coreApp.model.dto.request.SprintRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.SprintResponseDTO;
import dz.corepulse.projectflow.coreApp.services.SprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coreapp/sprint")
@RequiredArgsConstructor
public class SprintController {

    private final SprintService sprintService;

    @PostMapping("/create")
    public ResponseEntity<SprintResponseDTO>  createSprint(@RequestBody SprintRequestDTO dto) {
        return ResponseEntity.ok(sprintService.createSprint(dto));
    }
}
