package dz.corepulse.projectflow.coreApp.controllers;

import dz.corepulse.projectflow.coreApp.model.dto.request.ProjectRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.ProjectResponseDTO;
import dz.corepulse.projectflow.coreApp.services.ProjectService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coreapp/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("all-projects")
    public ResponseEntity<Page<ProjectResponseDTO>> getAllProjects(@RequestParam(defaultValue = "0") int number,
                                                                   @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(projectService.getAllProjects(number, size));
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectRequestDTO projectRequestDTO) {
        return ResponseEntity.ok(projectService.createProject(projectRequestDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<ProjectResponseDTO> updateProject(@RequestParam Long id,
                                                            @RequestBody ProjectRequestDTO projectRequestDTO) {
        return ResponseEntity.ok(projectService.updateProject(id, projectRequestDTO));
    }

    @DeleteMapping("/delete")
    public void deleteProject(@RequestParam Long id) {
        projectService.deleteProject(id);
    }
}
