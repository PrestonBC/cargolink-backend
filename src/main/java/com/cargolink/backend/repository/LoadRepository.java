package com.cargolink.backend.repository;
import com.cargolink.backend.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoadRepository extends JpaRepository<Load, UUID> {
    
}
