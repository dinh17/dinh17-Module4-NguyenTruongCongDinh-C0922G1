package com.example.case_study.repository.contract;


import com.example.case_study.dto.contract.IContractDto;
import com.example.case_study.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select c.id , c.start_date as startDate, c.end_date as endDate , c.deposit , ct.name as customerName , f.name as facilityName , (ifnull(f.cost, 0) + (sum(ifnull(af.cost, 0) * ifnull(cd.quantity, 0)))) as total from `contract` c left join `facility` f on f.id = c.facility_id left join `contract_detail` cd on c.id = cd.contract_id left join `attach_facility` af on af.id = cd.attach_facility_id join `customer` ct on c.customer_id = ct.id group by c.id", nativeQuery = true)
    Page<IContractDto> findAllContract(Pageable pageable);


}
