package com.tarikb.issuemanagement.dto;

import com.tarikb.issuemanagement.entity.Issue;
import com.tarikb.issuemanagement.entity.IssueStatus;
import com.tarikb.issuemanagement.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

@ApiModel(value = "Issue Hıstory Data Transfer Object")
public class IssueHistoryDto {

    @ApiModelProperty(required = true,value = "ID")
    private Long id;
    @ApiModelProperty(required = true,value = "Issue")
    private Issue issue;
    @ApiModelProperty(required = true,value = "Description")
    private String description;
    @ApiModelProperty(required = true,value = "Date")
    private Date date;
    @ApiModelProperty(required = true,value = "IssueStatus")
    private IssueStatus issueStatus;
    @ApiModelProperty(required = true,value = "Details")
    private String details;
    @ApiModelProperty(required = true,value = "Assignee")
    private User assignee;
}
