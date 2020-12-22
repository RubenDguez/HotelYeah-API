package com.revature.hotelbooking.hotelbooking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "room_type")
public class RoomType extends AuditModel {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "room_type_generator")
    @SequenceGenerator(name = "room_type_generator", sequenceName = "room_type_generator", initialValue = 1000)
    private Long id;

    @NotNull
    private String code;

    @NotNull
    private String description;

    public RoomType() {
        super();
    }

    public RoomType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

    
}
