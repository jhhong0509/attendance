package com.example.check.entity.attendance;

import com.example.check.entity.student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

    List<Attendance> findAllByStudentAndDateTimeBetween(Student student, LocalDateTime startDate, LocalDateTime endDate);

    List<Attendance> findAllByDateTimeBetweenOrderByDateTimeDesc(LocalDateTime startDate, LocalDateTime endDate);

    List<Attendance> findAllByStudentOrderByDateTimeDesc(Student student);

    Integer countAllByStudent(Student student);

    Integer countAllBy();

    Integer countAllByDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);

}
