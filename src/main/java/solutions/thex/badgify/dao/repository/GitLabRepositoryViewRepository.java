package solutions.thex.badgify.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import solutions.thex.badgify.dao.GitLabRepositoryView;

import java.util.Optional;

@Repository
public interface GitLabRepositoryViewRepository extends MongoRepository<GitLabRepositoryView, String> {

    Optional<GitLabRepositoryView> findByProfileAndRepo(String profile, String repo);

}
