package com.guitarhammer.server.repositories;

import com.guitarhammer.server.models.ChordGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChordGroupRepository extends JpaRepository<ChordGroup, Long> {
    ChordGroup findByGroupName(String s);
}
