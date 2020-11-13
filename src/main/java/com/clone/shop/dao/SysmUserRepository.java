package com.clone.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.clone.shop.dto.SysmUser;
/*
 * JpaRepository<T, ID>
 * Generic T 	: entity class
 * ID 			: entity pk
 */
@Transactional
@Repository
public interface SysmUserRepository extends JpaRepository<SysmUser, Long>{	
	/*
	 * 인터페이스가 너무 많음..
	 * findAll
	 * findOne
	 * findById
	 * existsById
	 * count
	 * deleteById
	 * delete
	 * deleteAll
	 * findAllById
	 * flush
	 * deleteInBatch
	 * deleteAllInBatch
	 * getOne
	 * save
	 */
	void deleteByEmail(String email);
	SysmUser findByEmail(String email);
}
