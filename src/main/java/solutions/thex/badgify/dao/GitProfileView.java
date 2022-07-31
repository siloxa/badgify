package solutions.thex.badgify.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("profile-view")
@Builder
@Data
public class GitProfileView {

    @Id
    private String id;
    @Indexed(unique=true)
    private String profile;
    private long count;

}
