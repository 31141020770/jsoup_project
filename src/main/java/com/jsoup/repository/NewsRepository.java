package com.jsoup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsoup.entity.NewsEntity;

public interface NewsRepository extends JpaRepository<NewsEntity,Long>{
 NewsEntity findOneByUrl(String url);
 Boolean existsByUrl(String url);
 List<NewsEntity> findByWebnameCode(String code);
 List<NewsEntity> findById(long time);
}
