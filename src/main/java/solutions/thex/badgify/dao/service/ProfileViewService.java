package solutions.thex.badgify.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solutions.thex.badgify.dao.ProfileView;
import solutions.thex.badgify.dao.repository.ProfileViewRepository;

import java.util.Optional;

@Service
public class ProfileViewService {

    private final ProfileViewRepository profileViewRepository;

    @Autowired
    public ProfileViewService(ProfileViewRepository profileViewRepository) {
        this.profileViewRepository = profileViewRepository;
    }

    public ProfileView save(ProfileView profileView) {
        return profileViewRepository.save(profileView);
    }

    public Optional<ProfileView> getByProfile(String profile) {
        return profileViewRepository.findByProfile(profile);
    }

}
