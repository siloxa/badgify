package io.github.shuoros.badgify.domain;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.shuoros.badgify.web.rest.TestUtil;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class BadgeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Badge.class);
        Badge badge1 = new Badge();
        badge1.setId(UUID.randomUUID());
        Badge badge2 = new Badge();
        badge2.setId(badge1.getId());
        assertThat(badge1).isEqualTo(badge2);
        badge2.setId(UUID.randomUUID());
        assertThat(badge1).isNotEqualTo(badge2);
        badge1.setId(null);
        assertThat(badge1).isNotEqualTo(badge2);
    }
}
