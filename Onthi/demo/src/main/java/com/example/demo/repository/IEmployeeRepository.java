package com.example.demo.repository;

import com.example.demo.model.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select * from employee where name like concat('%',:name,'%') and email like concat('%',:email,'%')",nativeQuery = true )
    Page<Employee> searchName(@Param("name") String name, @Param("email") String email,Pageable pageable);
}
