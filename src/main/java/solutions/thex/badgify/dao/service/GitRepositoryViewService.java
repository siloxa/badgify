package solutions.thex.badgify.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solutions.thex.badgify.dao.GitRepositoryView;
import solutions.thex.badgify.dao.repository.GitRepositoryViewRepository;

import java.util.Optional;

@Service
public class GitRepositoryViewService {

    private final GitRepositoryViewRepository repositoryViewRepository;

    @Autowired
    public GitRepositoryViewService(GitRepositoryViewRepository repositoryViewRepository) {
        this.repositoryViewRepository = repositoryViewRepository;
    }

    public GitRepositoryView save(GitRepositoryView repositoryView) {
        return repositoryViewRepository.save(repositoryView);
    }

    public Optional<GitRepositoryView> getByProfileAndRepo(String profile, String repo) {
        return repositoryViewRepository.findByProfileAndRepo(profile, repo);
    }

}
