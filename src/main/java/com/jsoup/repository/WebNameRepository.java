package com.jsoup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsoup.entity.WebNameEntity;

public interface WebNameRepository extends JpaRepository<WebNameEntity, Long>{
 WebNameEntity findOneByCode(String Code);
}
