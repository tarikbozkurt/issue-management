package com.tarikb.issuemanagement.api;


import com.tarikb.issuemanagement.dto.ProjectDto;
import com.tarikb.issuemanagement.service.impl.ProjectServiceImpl;
import com.tarikb.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.projectCtrl.CTRL)
@Api(value = "Project APIs")
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
    @ApiOperation(value = "Get By Id Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id",required = true) Long id) {
        /* servisimiz " projectServiceImpl " gelen id yi gidip getirecek ve projectDto geri dönderecek.. b*/
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto>  createProject(@Validated @RequestBody ProjectDto project){
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id",required = true) Long id, @Validated @RequestBody ProjectDto project){

        return ResponseEntity.ok(projectServiceImpl.update(id,project));

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation",response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){

        return ResponseEntity.ok(projectServiceImpl.delete(id));

    }
}
