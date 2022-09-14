package com.tarikb.issuemanagement.api;


import com.tarikb.issuemanagement.dto.ProjectDto;
import com.tarikb.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    /**
     * Http Metodları
     * GET
     * POST
     * PUT
     * DELETE
     */

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id",required = true) Long id) {
        /* servisimiz " projectServiceImpl " gelen id yi gidip getirecek ve projectDto geri dönderecek.. b*/
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    public ResponseEntity<ProjectDto>  createProject(@Validated @RequestBody ProjectDto project){
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id",required = true) Long id, @Validated @RequestBody ProjectDto project){

        return ResponseEntity.ok(projectServiceImpl.update(id,project));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id",required = true) Long id){

        return ResponseEntity.ok(projectServiceImpl.delete(id));

    }
}
