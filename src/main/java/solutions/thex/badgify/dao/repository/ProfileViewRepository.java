package solutions.thex.badgify.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import solutions.thex.badgify.dao.ProfileView;

import java.util.Optional;

@Repository
public interface ProfileViewRepository extends MongoRepository<ProfileView, String> {

    Optional<ProfileView> findByProfile(String profile);

}
