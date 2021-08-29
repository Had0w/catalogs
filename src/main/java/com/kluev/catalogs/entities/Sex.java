package com.kluev.catalogs.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "sex")
@Data
@DynamicUpdate
@JsonAutoDetect
public class Sex {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "code")
    private char code;

    @Column(name = "updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updatedAt;

    @Column(name = "nsi_global_id")
    private int nsiGlobalId;

    @Column(name = "nsi_id")
    private int nsiId;

    @Column(name = "nsi_title")
    private int nsiTitle;

    @Column(name = "nsi_del")
    private boolean nsiDel;

    public Sex() {
        if(updatedAt == null) {
            updatedAt = LocalDateTime.now();
        }
    }
}
