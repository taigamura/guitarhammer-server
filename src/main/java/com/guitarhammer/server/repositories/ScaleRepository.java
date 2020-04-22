package com.guitarhammer.server.repositories;

import com.guitarhammer.server.models.Scale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScaleRepository extends JpaRepository<Scale, Long> {
}
