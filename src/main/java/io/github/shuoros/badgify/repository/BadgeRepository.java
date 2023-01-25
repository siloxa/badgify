package io.github.shuoros.badgify.repository;

import io.github.shuoros.badgify.domain.Badge;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Badge entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BadgeRepository extends JpaRepository<Badge, UUID> {
    @Query("select badge from Badge badge where badge.user.login = ?#{principal.username}")
    List<Badge> findByUserIsCurrentUser();
}
