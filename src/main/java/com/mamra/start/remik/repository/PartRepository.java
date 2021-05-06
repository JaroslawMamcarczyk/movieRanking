package com.mamra.start.remik.repository;

import com.mamra.start.remik.domain.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part,Long> {
}
