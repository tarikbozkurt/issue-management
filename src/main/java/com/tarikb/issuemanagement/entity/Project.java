package com.tarikb.issuemanagement.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Project extends BaseEntitiy{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="projectCode",length = 100,unique = true)
    private String projectCode;

    @Column(name="projectName",length = 100)
    private String projectName;

    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User manager;
}
