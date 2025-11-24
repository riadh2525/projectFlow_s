package dz.corepulse.projectflow.coreApp.services.servicesImpl;

import dz.corepulse.projectflow.coreApp.mappers.TaskMapper;
import dz.corepulse.projectflow.coreApp.model.dto.request.TaskRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.TaskResponseDTO;
import dz.corepulse.projectflow.coreApp.model.entity.Task;
import dz.corepulse.projectflow.coreApp.model.enums.statuses.TaskStatus;
import dz.corepulse.projectflow.coreApp.repository.TaskRepo;
import dz.corepulse.projectflow.coreApp.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;
    private final TaskMapper taskMapper;

    @Override
    public Page<TaskResponseDTO> getAllTasks(int number, int size) {
        Pageable pageable = PageRequest.of(number, size);
        return taskRepo.findAll(pageable).map(taskMapper::toDto);
    }

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {
        Task task = taskMapper.toEntity(taskRequestDTO);
        //other code here to bring the creator
//        story.setCreatedBy();
        return taskMapper.toDto(taskRepo.save(task));
    }

    @Override
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO taskRequestDTO) {
        Task actual = taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task with ID: "+id+"not found!"));
        Task updated = taskMapper.toEntity(taskRequestDTO);
        if(actual.isSame(updated)) throw  new RuntimeException("Nothing to update!");
        //other code here to bring the updater
//        updated.setCreatedBy();
        updated.setId(id);
        return taskMapper.toDto(taskRepo.save(updated));
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task with ID: "+id+"not found!"));
        //other code here to bring the deleter
//        task.setCreatedBy();
        task.setStatus(TaskStatus.ANY_1);
        taskRepo.save(task);
    }
}
