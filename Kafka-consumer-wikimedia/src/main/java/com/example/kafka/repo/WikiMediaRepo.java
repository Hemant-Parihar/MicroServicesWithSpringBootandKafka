package com.example.kafka.repo;

import com.example.kafka.model.WikiMediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiMediaRepo extends JpaRepository<WikiMediaData, Long> {

}
