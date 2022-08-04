package solutions.thex.badgify.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import solutions.thex.badgify.dao.GitLabProfileView;

import java.util.Optional;

@Repository
public interface GitLabProfileViewRepository extends MongoRepository<GitLabProfileView, String> {

    Optional<GitLabProfileView> findByProfile(String profile);

}
