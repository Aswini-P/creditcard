package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.CreditCard;
@Repository
public interface ICreditCardRepository extends JpaRepository<CreditCard,Long> {

}