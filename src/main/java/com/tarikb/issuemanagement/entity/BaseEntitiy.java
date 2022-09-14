package com.tarikb.issuemanagement.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;



@MappedSuperclass //Diğer classlardan extend edilebileceğini sağlar
@Getter
@Setter
public abstract class BaseEntitiy implements Serializable {
    //abstract yaptık çünli override etmek isteyebiliriz.
    // Tüm tablolarda ortak olarak kullanacağım özellikler..
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "created_by",length = 100)
    private String createdBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "updated_by",length = 100)
    private String updatedBy;

    @Column(name = "status")
    private Boolean status;
    //lombok getter ve setter ları otomatik sağlıyor..
    //@Data bir interface attributlerimizi ekliyor..






}
