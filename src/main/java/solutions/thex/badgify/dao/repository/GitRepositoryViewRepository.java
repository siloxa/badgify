package solutions.thex.badgify.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import solutions.thex.badgify.dao.GitRepositoryView;

import java.util.Optional;

@Repository
public interface GitRepositoryViewRepository extends MongoRepository<GitRepositoryView, String> {

    Optional<GitRepositoryView> findByProfileAndRepo(String profile, String repo);

}
