package com.tarikb.issuemanagement.api;

import com.tarikb.issuemanagement.dto.IssueDto;
import com.tarikb.issuemanagement.service.impl.IssueServiceImpl;
import com.tarikb.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
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

    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id",required = true) Long id) {
        /* servisimiz " projectServiceImpl " gelen id yi gidip getirecek ve projectDto geri dönderecek.. b*/
        IssueDto projectDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    public ResponseEntity<IssueDto>  createProject(@Validated @RequestBody IssueDto project){
        return ResponseEntity.ok(issueServiceImpl.save(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id",required = true) Long id, @Validated @RequestBody IssueDto project){

        return ResponseEntity.ok(issueServiceImpl.update(id,project));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){

        return ResponseEntity.ok(issueServiceImpl.delete(id));

    }
}
