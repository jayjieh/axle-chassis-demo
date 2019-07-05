/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axle.chassisdemo.demo.entity;

import ke.axle.chassis.annotations.EditDataWrapper;
import ke.axle.chassis.annotations.EditEntity;
import ke.axle.chassis.annotations.EditEntityId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Owori Juma
 */
@Entity
@Table(name = "demo_edited")
@Getter
@Setter
public class DemoEdittedRecord implements Serializable {
    @EditEntity
    private String ufsEntity;
    @EditEntityId
    private String entityId;
    @Size(max = 4000)
    @EditDataWrapper
    private String data;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Long id;

    public DemoEdittedRecord() {
    }
}
