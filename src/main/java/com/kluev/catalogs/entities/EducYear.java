package com.kluev.catalogs.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "educ_year")
@Data
@NoArgsConstructor
public class EducYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private int year;

    @Column(name = "sdate")
    private LocalDateTime startDate;

    @Column(name = "edate")
    private LocalDateTime endDate;

    @Override
    public String toString() {
        return "EducYear{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
