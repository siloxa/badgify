package solutions.thex.badgify.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import solutions.thex.badgify.dao.GitHubRepositoryView;

import java.util.Optional;

@Repository
public interface GitHubRepositoryViewRepository extends MongoRepository<GitHubRepositoryView, String> {

    Optional<GitHubRepositoryView> findByProfileAndRepo(String profile, String repo);

}
