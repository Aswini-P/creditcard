package com.cg.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Customer;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
	@Query(value = "select obj from Customer obj where obj.userId=:name")
	Customer findByUserId(@Param("name") String userId);
	
	@Query(value = "select obj from Customer obj where obj.userId=:#{#customer.userId}")
	Customer addCustomer(@Param("customer") Customer c);
	
	@Query(value = "select obj from Customer obj where obj.id=?1")
	Customer removeCustomer(long id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Customer SET userId = :#{#customer.userId}, name = :#{#customer.name}, email = :#{#customer.email}, contactNo= :#{#customer.contactNo}, dob = :#{#customer.dob} WHERE id = :id")
	void updateCustomer(@Param("id") long id, @Param("customer") Customer c);
	
	@Query(value = "select obj from Customer obj where obj.id=?1")
	Customer getCustomer(long id);
	
	@Query(value = "select obj from Customer obj")
	List<Customer> getAllCustomers();

}
