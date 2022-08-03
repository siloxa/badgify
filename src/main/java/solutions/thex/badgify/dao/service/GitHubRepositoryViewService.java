package solutions.thex.badgify.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solutions.thex.badgify.dao.GitHubRepositoryView;
import solutions.thex.badgify.dao.repository.GitHubRepositoryViewRepository;

import java.util.Optional;

@Service
public class GitHubRepositoryViewService {

    private final GitHubRepositoryViewRepository repositoryViewRepository;

    @Autowired
    public GitHubRepositoryViewService(GitHubRepositoryViewRepository repositoryViewRepository) {
        this.repositoryViewRepository = repositoryViewRepository;
    }

    public GitHubRepositoryView save(GitHubRepositoryView repositoryView) {
        return repositoryViewRepository.save(repositoryView);
    }

    public Optional<GitHubRepositoryView> getByProfileAndRepo(String profile, String repo) {
        return repositoryViewRepository.findByProfileAndRepo(profile, repo);
    }

}
