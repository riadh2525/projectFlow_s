package dz.corepulse.projectflow.coreApp.services;

import dz.corepulse.projectflow.coreApp.model.dto.request.ProjectRequestDTO;
import dz.corepulse.projectflow.coreApp.model.dto.response.ProjectResponseDTO;
import org.springframework.data.domain.Page;


public interface ProjectService {

    //default CRUD operations
    Page<ProjectResponseDTO> getAllProjects(int number, int size);

    ProjectResponseDTO createProject(ProjectRequestDTO projectRequestDTO);

    ProjectResponseDTO updateProject(Long id, ProjectRequestDTO projectRequestDTO);

    void deleteProject(Long id);

    //additional operations
}
