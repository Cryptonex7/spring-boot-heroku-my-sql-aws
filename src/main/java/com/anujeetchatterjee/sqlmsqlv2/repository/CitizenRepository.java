package com.anujeetchatterjee.sqlmsqlv2.repository;

import com.anujeetchatterjee.sqlmsqlv2.models.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
    List<Citizen> findByName(String name);
}
