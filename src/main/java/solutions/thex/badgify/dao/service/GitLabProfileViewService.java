package solutions.thex.badgify.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solutions.thex.badgify.dao.GitLabProfileView;
import solutions.thex.badgify.dao.repository.GitLabProfileViewRepository;

import java.util.Optional;

@Service
public class GitLabProfileViewService {

    private final GitLabProfileViewRepository profileViewRepository;

    @Autowired
    public GitLabProfileViewService(GitLabProfileViewRepository profileViewRepository) {
        this.profileViewRepository = profileViewRepository;
    }

    public GitLabProfileView save(GitLabProfileView profileView) {
        return profileViewRepository.save(profileView);
    }

    public Optional<GitLabProfileView> getByProfile(String profile) {
        return profileViewRepository.findByProfile(profile);
    }

}
