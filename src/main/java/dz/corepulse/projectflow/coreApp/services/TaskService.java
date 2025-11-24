package dz.corepulse.projectflow.coreApp.services;

import dz.corepulse.projectflow.coreApp.model.dto.request.TaskRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.TaskResponseDTO;
import org.springframework.data.domain.Page;

public interface TaskService {

    Page<TaskResponseDTO> getAllTasks(int number, int size);

    TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO);

    TaskResponseDTO updateTask(Long id, TaskRequestDTO taskRequestDTO);

    void deleteTask(Long id);
}
