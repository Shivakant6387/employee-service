package com.example.addressservice.repository;

import com.example.addressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query(nativeQuery = true ,value = "select ea.id,ea.lane1,ea.lane2,ea.state,ea.zip from mydb.address ea join employee e on e.id=ea.employee_id where ea.employee_id=:employeeId")
    Address findAddressByEmployeeId(@Param("employeeId")int  employeeId);
}