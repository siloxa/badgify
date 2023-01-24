package solutions.thex.badgify.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import solutions.thex.badgify.dao.GitHubProfileView;

import java.util.Optional;

@Repository
public interface GitHubProfileViewRepository extends MongoRepository<GitHubProfileView, String> {

    Optional<GitHubProfileView> findByProfile(String profile);

}
