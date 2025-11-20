package dz.corepulse.projectflow.coreApp.services.servicesImpl;

import dz.corepulse.projectflow.coreApp.mappers.ProjectMapper;
import dz.corepulse.projectflow.coreApp.model.dto.request.ProjectRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.ProjectResponseDTO;
import dz.corepulse.projectflow.coreApp.model.entity.Project;
import dz.corepulse.projectflow.coreApp.model.enums.statuses.ProjectStatus;
import dz.corepulse.projectflow.coreApp.repository.ProjectRepo;
import dz.corepulse.projectflow.coreApp.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepo projectRepo;
    private final ProjectMapper projectMapper;

    @Override
    public Page<ProjectResponseDTO> getAllProjects(int number, int size) {
        Pageable pageable = PageRequest.of(number, size);
        return projectRepo.findAll(pageable)
                .map(projectMapper::toDto);
    }

    @Override
    public ProjectResponseDTO createProject(ProjectRequestDTO projectRequestDTO) {
        return projectMapper.toDto(projectRepo.save(projectMapper.toEntity(projectRequestDTO)));
    }

    @Override
    public ProjectResponseDTO updateProject(Long id, ProjectRequestDTO projectRequestDTO) {
        Project projectInDB = projectRepo.findById(id).orElseThrow(() -> new RuntimeException("Project with id " + id + " not found"));
        Project updated =  projectMapper.toEntity(projectRequestDTO);
        if(projectInDB.equals(updated)) {
            throw new RuntimeException("Nothing to update!");
        }
        updated.setId(id);
        projectRepo.save(updated);
        return projectMapper.toDto(updated);
    }

    @Override
    public void deleteProject(Long id) {
        Project project = projectRepo.findById(id).orElseThrow(() -> new RuntimeException("Project with id " + id + " not found"));
        project.setStatus(ProjectStatus.ABANDONED);
        projectRepo.save(project);
    }
}
