package com.tarikb.issuemanagement.repository;

import com.tarikb.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProjectRepository extends JpaRepository<Project,Long> {

    Project getByProjectCode(String projectCode);
    List<Project> getByProjectCodeContains(String projectCode);

    //sayfalama - kaçıncı kayıttan başlasın kaçarlı gelsin sıralama yapsın mı gibi..
    Page<Project> findAll(Pageable pageable);
    // sıralama sorting kayıtlar üzerinde
    List<Project> findAll(Sort sort);


    Project getByProjectCodeAndIdNot(String projectCode, Long id);
}
