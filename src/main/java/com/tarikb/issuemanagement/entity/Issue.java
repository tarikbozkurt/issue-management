package com.tarikb.issuemanagement.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issue")
@Data
@NoArgsConstructor //boş constructor oluşturmak için
@AllArgsConstructor //tüm fieldlar kullanılarak yapılan constructor
@ToString //nesnelerin toString metodunu override ediyor.
@EqualsAndHashCode
public class Issue extends BaseEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="description",length = 400)
    private String description;

    @Column(name="details",length = 4000)
    private String details;

    @Column(name="date")
    private Date date;

    @Column(name="IssueStatus")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;


    @JoinColumn(name="assignee_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY) //ihtiyaç olduğunda lazy ile getirilir, eager direkt getirir.
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Project project;

}
