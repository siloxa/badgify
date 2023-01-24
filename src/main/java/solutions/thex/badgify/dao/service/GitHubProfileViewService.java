package solutions.thex.badgify.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solutions.thex.badgify.dao.GitHubProfileView;
import solutions.thex.badgify.dao.repository.GitHubProfileViewRepository;

import java.util.Optional;

@Service
public class GitHubProfileViewService {

    private final GitHubProfileViewRepository profileViewRepository;

    @Autowired
    public GitHubProfileViewService(GitHubProfileViewRepository profileViewRepository) {
        this.profileViewRepository = profileViewRepository;
    }

    public GitHubProfileView save(GitHubProfileView profileView) {
        return profileViewRepository.save(profileView);
    }

    public Optional<GitHubProfileView> getByProfile(String profile) {
        return profileViewRepository.findByProfile(profile);
    }

}
