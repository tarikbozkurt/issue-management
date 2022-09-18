package com.tarikb.issuemanagement.api;

import com.tarikb.issuemanagement.dto.IssueDto;
import com.tarikb.issuemanagement.dto.ProjectDto;
import com.tarikb.issuemanagement.service.impl.IssueServiceImpl;
import com.tarikb.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value = ApiPaths.IssueCtrl.CTRL,tags = "Issue APIs")
public class IssueController {

    /**
     * Http Metodları
     * GET
     * POST
     * PUT
     * DELETE
     */

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {

        this.issueServiceImpl = issueServiceImpl;
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get Issue by Id",response = IssueDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id",required = true) Long id) {
        /* servisimiz " projectServiceImpl " gelen id yi gidip getirecek ve projectDto geri dönderecek.. b*/
        IssueDto projectDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Issue",response = IssueDto.class)
    public ResponseEntity<IssueDto>  createIssue(@Validated @RequestBody IssueDto project){
        return ResponseEntity.ok(issueServiceImpl.save(project));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "update Issue",response = IssueDto.class)
    public ResponseEntity<IssueDto> updateIssue(@PathVariable(value = "id",required = true) Long id, @Validated @RequestBody IssueDto project){

        return ResponseEntity.ok(issueServiceImpl.update(id,project));

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Issue",response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){

        return ResponseEntity.ok(issueServiceImpl.delete(id));

    }
}
