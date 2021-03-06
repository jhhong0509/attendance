package com.example.check.entity.student;

import com.example.check.entity.attendance.Attendance;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_tbl")
public class Student {

    @Id
    private String id;

    @Column(name = "nickname", nullable = true)
    private String nickname;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    @JsonBackReference
    private List<Attendance> attendanceList;

    public Student update(String nickname) {
        this.nickname = nickname;
        return this;
    }

}
