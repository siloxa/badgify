package solutions.thex.badgify.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@CompoundIndex(def = "{'storeId': 1, 'number': 1}", unique = true)
@Document("repo-view")
@Builder
@Data
public class GitRepositoryView {

    @Id
    private String id;
    private String profile;
    private String repo;
    private long count;

}
