package com.example.onthi2.repository;

import com.example.onthi2.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product,Integer> {
@Query(value="select * from product where name like concat('%',:name,'%') and describer like concat('%',:describer ,'%')",nativeQuery = true)
    Page<Product> searchName(@Param("name") String name, @Param("describer")String describer, Pageable pageable);

}
