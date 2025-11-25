package dz.corepulse.projectflow.coreApp.controllers;

import dz.corepulse.projectflow.coreApp.model.dto.request.SprintRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.SprintResponseDTO;
import dz.corepulse.projectflow.coreApp.services.SprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coreapp/sprint")
@RequiredArgsConstructor
public class SprintController {

    private final SprintService sprintService;

    @GetMapping("/get-sprints")
    public ResponseEntity<Page<SprintResponseDTO>> getSprints(@RequestParam(defaultValue = "0") int number, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(sprintService.getAllSprints(number, size));
    }

    @GetMapping("/sprint-by-id")
    public ResponseEntity<SprintResponseDTO> getSprintById(@RequestParam long id) {
        return ResponseEntity.ok(sprintService.getSprintById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<SprintResponseDTO>  createSprint(@RequestBody SprintRequestDTO dto) {
        return ResponseEntity.ok(sprintService.createSprint(dto));
    }

    @PutMapping("/update")
    public ResponseEntity<SprintResponseDTO> updateSprint(@RequestParam Long id, @RequestBody SprintRequestDTO dto) {
        return ResponseEntity.ok(sprintService.updateSprint(id, dto));
    }

    @DeleteMapping("/delete")
    public void deleteSprint(@RequestParam Long id) {
        sprintService.deleteSprint(id);
    }
}
