package com.tarikb.issuemanagement.service.impl;

import com.tarikb.issuemanagement.entity.Project;
import com.tarikb.issuemanagement.repository.ProjectRepository;
import com.tarikb.issuemanagement.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {


    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {

        if(project.getProjectCode() == null) {
        throw new IllegalArgumentException("Missing Project Code !!(Cannot be null!)");
        }

        project = projectRepository.save(project);
        return project;
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getReferenceById(id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        projectRepository.delete(project);

        return Boolean.TRUE;
    }
}
