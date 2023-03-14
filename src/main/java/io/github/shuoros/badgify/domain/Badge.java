package io.github.shuoros.badgify.domain;

import com.vladmihalcea.hibernate.type.json.JsonType;
import io.github.shuoros.badgify.domain.enumeration.BadgeType;
import io.github.shuoros.badgify.domain.model.badge.AbstractBadge;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

/**
 * A Badge.
 */
@Entity
@Table(name = "badge")
@TypeDef(name = "json", typeClass = JsonType.class)
public class Badge implements Serializable {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "id", length = 36)
    private UUID id;

    @Type(type = "json")
    @Column(name = "badge", columnDefinition = "json")
    private AbstractBadge badge;

    @Enumerated(EnumType.STRING)
    @Column(name = "badge_type")
    private BadgeType badgeType;

    @Column(name = "count")
    private Long count;

    @ManyToOne
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public UUID getId() {
        return this.id;
    }

    public Badge id(UUID id) {
        this.setId(id);
        return this;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AbstractBadge getBadge() {
        return this.badge;
    }

    public Badge badge(AbstractBadge badge) {
        this.setBadge(badge);
        return this;
    }

    public void setBadge(AbstractBadge badge) {
        this.badge = badge;
    }

    public BadgeType getBadgeType() {
        return this.badgeType;
    }

    public Badge badgeType(BadgeType badgeType) {
        this.setBadgeType(badgeType);
        return this;
    }

    public void setBadgeType(BadgeType badgeType) {
        this.badgeType = badgeType;
    }

    public Long getCount() {
        return this.count;
    }

    public Badge count(Long count) {
        this.setCount(count);
        return this;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Badge user(User user) {
        this.setUser(user);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Badge)) {
            return false;
        }
        return id != null && id.equals(((Badge) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Badge{" +
            "id=" + getId() +
            ", badge='" + getBadge() + "'" +
            ", badgeType='" + getBadgeType() + "'" +
            ", count=" + getCount() +
            "}";
    }
}
