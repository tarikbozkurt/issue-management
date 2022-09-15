package com.tarikb.issuemanagement.service.impl;

import com.tarikb.issuemanagement.dto.ProjectDto;
import com.tarikb.issuemanagement.entity.Project;
import com.tarikb.issuemanagement.repository.ProjectRepository;
import com.tarikb.issuemanagement.service.ProjectService;
import com.tarikb.issuemanagement.util.Tpage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {


    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;


    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());

        if(projectCheck!=null)
            throw new IllegalArgumentException("Project Code Already Exist!");


        Project p = modelMapper.map(project,Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);

    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Tpage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
    Tpage<ProjectDto> response = new Tpage<ProjectDto>();
    response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(),ProjectDto[].class)));
    return response;

    }

    @Override
    public Boolean delete(ProjectDto project) {
       return null;
    }

    public Boolean delete(Long id) {
         projectRepository.deleteById(id);
         return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {

        Project projectDb = projectRepository.getOne(id);
        if(projectDb == null)
            throw new IllegalArgumentException("Project doesnt exists ! ID:"+id);


        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(),id);

        if(projectCheck!=null && projectCheck.getId() != projectDb.getId())
            throw new IllegalArgumentException("Project Code Already Exist!");


        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());

        projectRepository.save(projectDb);
        return modelMapper.map(projectDb,ProjectDto.class);
    }
    public List<ProjectDto> getAll() {
        List<Project> data = projectRepository.findAll();
        return Arrays.asList(modelMapper.map(data, ProjectDto[].class));
    }
}
