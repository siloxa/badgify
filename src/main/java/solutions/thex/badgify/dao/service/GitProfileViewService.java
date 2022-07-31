package solutions.thex.badgify.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solutions.thex.badgify.dao.GitProfileView;
import solutions.thex.badgify.dao.repository.GitProfileViewRepository;

import java.util.Optional;

@Service
public class GitProfileViewService {

    private final GitProfileViewRepository profileViewRepository;

    @Autowired
    public GitProfileViewService(GitProfileViewRepository profileViewRepository) {
        this.profileViewRepository = profileViewRepository;
    }

    public GitProfileView save(GitProfileView profileView) {
        return profileViewRepository.save(profileView);
    }

    public Optional<GitProfileView> getByProfile(String profile) {
        return profileViewRepository.findByProfile(profile);
    }

}
