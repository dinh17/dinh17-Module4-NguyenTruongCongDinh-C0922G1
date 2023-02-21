package com.example.case_study.repository;

import com.example.case_study.model.facility.Facility;
import com.example.case_study.model.facility.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    @Query(value = "select * from facility where name like concat('%',:name,'%') and is_deleted=false ", nativeQuery = true)
    Page<Facility> searchName(@Param("name") String name, Pageable pageable);

    @Query(value = "select * from facility where name like concat('%',:name,'%') and facility_type_id = :id and is_deleted=false ", nativeQuery = true)
    Page<Facility> searchNameAndFacilityType(@Param("name") String name, @Param("id") Integer typeId, Pageable pageable);

    Facility findByName(String name);
}
