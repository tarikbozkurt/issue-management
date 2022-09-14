package com.tarikb.issuemanagement.service.impl;

import com.tarikb.issuemanagement.dto.IssueDto;
import com.tarikb.issuemanagement.entity.Issue;
import com.tarikb.issuemanagement.util.Tpage;
import org.modelmapper.ModelMapper;
import com.tarikb.issuemanagement.repository.IssueRepository;
import com.tarikb.issuemanagement.service.IssueService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;


@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;


    //bir propertye dışarıdan atamayı engellemiş oluyorz, final nesneye atamayı constructor da yapmış olduk.
    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper){
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public IssueDto save(IssueDto issue) {
        if(issue.getDate() == null){
            throw new IllegalArgumentException("Issue date cannot be null!");
        }
        Issue issueDb =  modelMapper.map(issue,Issue.class);

        issueDb = issueRepository.save(issueDb);

        return modelMapper.map(issueDb,IssueDto.class);

    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public Tpage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        Tpage page = new Tpage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }
}
