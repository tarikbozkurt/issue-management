package com.tarikb.issuemanagement.repository;

import com.tarikb.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

//
public interface IssueRepository extends JpaRepository<Issue,Long> {


}
