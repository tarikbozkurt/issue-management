package com.tarikb.issuemanagement.service;

import com.tarikb.issuemanagement.dto.ProjectDto;
import com.tarikb.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    ProjectDto getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete(Project project);

    ProjectDto update(Long id, ProjectDto project);
}
