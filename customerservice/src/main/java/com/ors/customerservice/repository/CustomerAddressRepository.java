package com.ors.customerservice.repository;

import com.ors.customerservice.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, UUID> {
//    @Transactional
//    @Modifying
//    @Query("update CustomerAddress c set c.customerAddressId = ?1")
//    void updateCustomerAddressIdBy(UUID customerAddressId);
}

