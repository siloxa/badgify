package solutions.thex.badgify.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import solutions.thex.badgify.dao.RepositoryView;

import java.util.Optional;

@Repository
public interface RepositoryViewRepository extends MongoRepository<RepositoryView, String> {

    Optional<RepositoryView> findByProfileAndRepo(String profile, String repo);

}
