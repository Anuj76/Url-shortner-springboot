package com.example.UrlShortner.repository;

import org.springframework.stereotype.Repository;

import com.example.UrlShortner.entity.Url;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long>{

}
