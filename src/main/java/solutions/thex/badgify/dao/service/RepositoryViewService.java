package solutions.thex.badgify.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solutions.thex.badgify.dao.RepositoryView;
import solutions.thex.badgify.dao.repository.RepositoryViewRepository;

import java.util.Optional;

@Service
public class RepositoryViewService {

    private final RepositoryViewRepository repositoryViewRepository;

    @Autowired
    public RepositoryViewService(RepositoryViewRepository repositoryViewRepository) {
        this.repositoryViewRepository = repositoryViewRepository;
    }

    public RepositoryView save(RepositoryView repositoryView) {
        return repositoryViewRepository.save(repositoryView);
    }

    public Optional<RepositoryView> getByProfileAndRepo(String profile, String repo) {
        return repositoryViewRepository.findByProfileAndRepo(profile, repo);
    }
}
