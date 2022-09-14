package com.tarikb.issuemanagement.repository;

import com.tarikb.issuemanagement.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {
}
