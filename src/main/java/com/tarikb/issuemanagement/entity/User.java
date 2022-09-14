package com.tarikb.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor //boş constructor oluşturmak için
@AllArgsConstructor //tüm fieldlar kullanılarak yapılan constructor
@ToString //nesnelerin toString metodunu override ediyor.
@EqualsAndHashCode
public class User extends BaseEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="username",length = 100,unique = true)
    private String username;

    @Column(name="pwd",length = 100)
    private String password;

    @Column(name="name_surname",length = 150)
    private String nameSurname;

    @Column(name="email",length = 100)
    private String email;


    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> issues;


}
