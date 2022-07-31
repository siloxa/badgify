package solutions.thex.badgify.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import solutions.thex.badgify.dao.GitProfileView;

import java.util.Optional;

@Repository
public interface GitProfileViewRepository extends MongoRepository<GitProfileView, String> {

    Optional<GitProfileView> findByProfile(String profile);

}
