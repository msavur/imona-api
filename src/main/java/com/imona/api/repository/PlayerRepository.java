package com.imona.api.repository;


import com.imona.core.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findById(Long playerId);
    List<Player> findAllByEnabledTrue();
}
