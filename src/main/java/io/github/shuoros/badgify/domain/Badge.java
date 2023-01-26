package io.github.shuoros.badgify.domain;

import io.github.shuoros.badgify.domain.enumeration.BadgeType;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * A Badge.
 */
@Entity
@Table(name = "badge")
public class Badge implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "id", length = 36)
    private UUID id;

    @Column(name = "badge")
    private String badge;

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

    public String getBadge() {
        return this.badge;
    }

    public Badge badge(String badge) {
        this.setBadge(badge);
        return this;
    }

    public void setBadge(String badge) {
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
