package dz.corepulse.projectflow.coreApp.controllers;

import dz.corepulse.projectflow.coreApp.model.dto.request.EpicRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.EpicResponseDTO;
import dz.corepulse.projectflow.coreApp.services.EpicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coreapp/epic")
@RequiredArgsConstructor
public class EpicController {

    private final EpicService epicService;

    @GetMapping("/all-epics")
    public ResponseEntity<Page<EpicResponseDTO>> getAllEpics(@RequestParam(defaultValue = "0") int number,
                                                             @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(epicService.getAllEpics(number, size));
    }

    @GetMapping("/epic-by-id")
    public ResponseEntity<EpicResponseDTO> getEpicById(@RequestParam Long id) {
        return ResponseEntity.ok(epicService.getEpicById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<EpicResponseDTO> createEpic(@RequestBody EpicRequestDTO epicRequestDTO) {
        return ResponseEntity.ok(epicService.createEpic(epicRequestDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<EpicResponseDTO> updateEpic(@RequestParam Long id,
                                                      @RequestBody EpicRequestDTO projectRequestDTO) {
        return ResponseEntity.ok(epicService.updateEpic(id, projectRequestDTO));
    }

    @DeleteMapping("/delete")
    public void deleteEpic(@RequestParam Long id) {
        epicService.deleteEpic(id);
    }
}
