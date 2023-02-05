package io.github.shuoros.badgify.repository;

import io.github.shuoros.badgify.domain.Badge;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Badge entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BadgeRepository extends JpaRepository<Badge, UUID> {
    @Query("select badge from Badge badge where badge.user.login = ?#{principal.username}")
    List<Badge> findByUserIsCurrentUser();

    @Query("SELECT b FROM Badge b WHERE JSON_EXTRACT(b.badge, '$.id') IS NOT NULL AND JSON_EXTRACT(b.badge, '$.id') = :id")
    Optional<Badge> findByBadge_id(@Param("id") String id);
}
