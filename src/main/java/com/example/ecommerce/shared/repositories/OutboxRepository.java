package com.example.ecommerce.shared.repositories;

import com.example.ecommerce.shared.entities.OutboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OutboxRepository extends JpaRepository<OutboxEntity, UUID> {

    Optional<OutboxEntity> findByIdAndStatus(UUID id, String status);
}
