package dz.corepulse.projectflow.coreApp.controllers;

import dz.corepulse.projectflow.coreApp.model.dto.request.TaskRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.TaskResponseDTO;
import dz.corepulse.projectflow.coreApp.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coreapp/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/get-tasks")
    public ResponseEntity<Page<TaskResponseDTO>> getTasks(int number, int size) {
        return ResponseEntity.ok(taskService.getAllTasks(number, size));
    }

    @GetMapping("/task-by-id")
    public ResponseEntity<TaskResponseDTO> getTaskById(Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        return ResponseEntity.ok(taskService.createTask(taskRequestDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<TaskResponseDTO> updateTask(@RequestParam Long id, @RequestBody TaskRequestDTO taskRequestDTO) {
        return ResponseEntity.ok(taskService.updateTask(id, taskRequestDTO));
    }

    @DeleteMapping("/delete")
    public void deleteTask(@RequestParam Long id) {
        taskService.deleteTask(id);
    }
}
