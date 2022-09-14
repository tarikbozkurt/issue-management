package com.tarikb.issuemanagement.service;

import com.tarikb.issuemanagement.dto.IssueDto;
import com.tarikb.issuemanagement.entity.Issue;
import com.tarikb.issuemanagement.util.Tpage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService  {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    Tpage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);


}
