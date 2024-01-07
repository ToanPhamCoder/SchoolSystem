package com.example.crud_basic.repository;

import com.example.crud_basic.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface GroupRepository extends JpaRepository<Group,Long> {
    @Query("SELECT g FROM Group g WHERE g.startDate < :endDate AND g.endDate > :startDate")
    List<Group> findGroupsByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    List<Group> findByStudentsId(Long studentId);

}
