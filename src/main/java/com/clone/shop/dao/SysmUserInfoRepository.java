package com.clone.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.clone.shop.dto.SysmUserInfo;
@Transactional
@Repository
public interface SysmUserInfoRepository extends JpaRepository<SysmUserInfo, Long>{	
}
