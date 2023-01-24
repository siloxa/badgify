package solutions.thex.badgify.controller.badge.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solutions.thex.badgify.dao.GitHubProfileView;
import solutions.thex.badgify.dao.GitHubRepositoryView;
import solutions.thex.badgify.dao.GitLabProfileView;
import solutions.thex.badgify.dao.GitLabRepositoryView;
import solutions.thex.badgify.dao.service.GitHubProfileViewService;
import solutions.thex.badgify.dao.service.GitHubRepositoryViewService;
import solutions.thex.badgify.dao.service.GitLabProfileViewService;
import solutions.thex.badgify.dao.service.GitLabRepositoryViewService;
import solutions.thex.badgify.exception.ServerException;
import solutions.thex.badgify.svg.wrapper.badge.LinkAsResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/counter")
public class ViewCounterBadgeController {

    private final GitHubProfileViewService gitHubProfileViewService;
    private final GitHubRepositoryViewService gitHubRepositoryViewService;
    private final GitLabProfileViewService gitLabProfileViewService;
    private final GitLabRepositoryViewService gitLabRepositoryViewService;
    private final LinkAsResponseWrapper linkAsResponseWrapper;

    @Autowired
    public ViewCounterBadgeController(GitHubProfileViewService gitHubProfileViewService, //
                                      GitHubRepositoryViewService gitHubRepositoryViewService,//
                                      GitLabProfileViewService gitLabProfileViewService,//
                                      GitLabRepositoryViewService gitLabRepositoryViewService,//
                                      LinkAsResponseWrapper linkAsResponseWrapper) {
        this.gitHubProfileViewService = gitHubProfileViewService;
        this.gitHubRepositoryViewService = gitHubRepositoryViewService;
        this.gitLabProfileViewService = gitLabProfileViewService;
        this.gitLabRepositoryViewService = gitLabRepositoryViewService;
        this.linkAsResponseWrapper = linkAsResponseWrapper;
    }

    @GetMapping(path = "/github/profile/{profile}", produces = "image/svg+xml")
    public ResponseEntity<String> githubProfileViews(HttpServletRequest request,//
                                                     @PathVariable(value = "profile") String profile,//
                                                     @RequestParam(value = "title", required = false, defaultValue = "Profile Views")//
                                                             String title,//
                                                     @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                             String theme,//
                                                     @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                             String size,//
                                                     @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                             String direction,//
                                                     @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                             String link,//
                                                     @RequestParam(value = "bg", required = false, defaultValue = "25425f")//
                                                             String bg,//
                                                     @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                             String color) throws Exception {
        title += " " + calculateGitHubProfileView(profile);
        return linkAsResponseWrapper.wrap(Map.of(//
                "title", title,//
                "icon", "eye",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", link,//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/github/repo/{profile}/{repo}", produces = "image/svg+xml")
    public ResponseEntity<String> githubRepoViews(HttpServletRequest request,//
                                                  @PathVariable(value = "profile") String profile,//
                                                  @PathVariable(value = "repo") String repo,//
                                                  @RequestParam(value = "title", required = false, defaultValue = "Repository Views")//
                                                          String title,//
                                                  @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                          String theme,//
                                                  @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                          String size,//
                                                  @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                          String direction,//
                                                  @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                          String link,//
                                                  @RequestParam(value = "bg", required = false, defaultValue = "25425f")//
                                                          String bg,//
                                                  @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                          String color) throws Exception {
        title += " " + calculateGitHubRepoView(profile, repo);
        return linkAsResponseWrapper.wrap(Map.of(//
                "title", title,//
                "icon", "eye",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", link,//
                "bg", bg,//
                "color", color));
    }

    private String calculateGitHubProfileView(String profile) {
        Optional<GitHubProfileView> maybeProfileView = getGitHubProfileView(profile);
        if (maybeProfileView.isPresent()) {
            GitHubProfileView profileView = maybeProfileView.get();
            profileView.setCount(profileView.getCount() + 1);
            updateGitHubProfileView(profileView);
            return summerizeView(profileView.getCount());
        } else {
            signUpNewGitHubProfileView(profile);
            return "1";
        }
    }

    private void updateGitHubProfileView(GitHubProfileView profileView) {
        try {
            gitHubProfileViewService.save(profileView);
        } catch (Exception e) {
            throw new ServerException();
        }
    }

    private void signUpNewGitHubProfileView(String profile) {
        GitHubProfileView profileView = GitHubProfileView.builder()//
                .profile(profile)//
                .count(1)//
                .build();
        try {
            gitHubProfileViewService.save(profileView);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException();
        }
    }

    private Optional<GitHubProfileView> getGitHubProfileView(String profile) {
        Optional<GitHubProfileView> profileView;
        try {
            profileView = gitHubProfileViewService.getByProfile(profile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException();
        }
        return profileView;
    }

    private String calculateGitHubRepoView(String profile, String repo) {
        Optional<GitHubRepositoryView> maybeRepoView = getGitHubRepoView(profile, repo);
        if (maybeRepoView.isPresent()) {
            GitHubRepositoryView repositoryView = maybeRepoView.get();
            repositoryView.setCount(repositoryView.getCount() + 1);
            updateGitHubRepoView(repositoryView);
            return summerizeView(repositoryView.getCount());
        } else {
            signUpNewGitHubRepoView(profile, repo);
            return "1";
        }
    }

    private void updateGitHubRepoView(GitHubRepositoryView repositoryView) {
        try {
            gitHubRepositoryViewService.save(repositoryView);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException();
        }
    }

    private void signUpNewGitHubRepoView(String profile, String repo) {
        GitHubRepositoryView repositoryView = GitHubRepositoryView.builder()//
                .profile(profile)//
                .repo(repo)//
                .count(1)//
                .build();
        try {
            gitHubRepositoryViewService.save(repositoryView);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException();
        }
    }

    private Optional<GitHubRepositoryView> getGitHubRepoView(String profile, String repo) {
        Optional<GitHubRepositoryView> repositoryView;
        try {
            repositoryView = gitHubRepositoryViewService.getByProfileAndRepo(profile, repo);
        } catch (Exception e) {
            throw new ServerException();
        }
        return repositoryView;
    }

    @GetMapping(path = "/gitlab/profile/{profile}", produces = "image/svg+xml")
    public ResponseEntity<String> gitlabProfileViews(HttpServletRequest request,//
                                                     @PathVariable(value = "profile") String profile,//
                                                     @RequestParam(value = "title", required = false, defaultValue = "Profile Views")//
                                                             String title,//
                                                     @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                             String theme,//
                                                     @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                             String size,//
                                                     @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                             String direction,//
                                                     @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                             String link,//
                                                     @RequestParam(value = "bg", required = false, defaultValue = "25425f")//
                                                             String bg,//
                                                     @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                             String color) throws Exception {
        title += " " + calculateGitLabProfileView(profile);
        return linkAsResponseWrapper.wrap(Map.of(//
                "title", title,//
                "icon", "eye",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", link,//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/gitlab/repo/{profile}/{repo}", produces = "image/svg+xml")
    public ResponseEntity<String> gitlabRepoViews(HttpServletRequest request,//
                                                  @PathVariable(value = "profile") String profile,//
                                                  @PathVariable(value = "repo") String repo,//
                                                  @RequestParam(value = "title", required = false, defaultValue = "Repository Views")//
                                                          String title,//
                                                  @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                          String theme,//
                                                  @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                          String size,//
                                                  @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                          String direction,//
                                                  @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                          String link,//
                                                  @RequestParam(value = "bg", required = false, defaultValue = "25425f")//
                                                          String bg,//
                                                  @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                          String color) throws Exception {
        title += " " + calculateGitLabRepoView(profile, repo);
        return linkAsResponseWrapper.wrap(Map.of(//
                "title", title,//
                "icon", "eye",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", link,//
                "bg", bg,//
                "color", color));
    }


    private String calculateGitLabProfileView(String profile) {
        Optional<GitLabProfileView> maybeProfileView = getGitLabProfileView(profile);
        if (maybeProfileView.isPresent()) {
            GitLabProfileView profileView = maybeProfileView.get();
            profileView.setCount(profileView.getCount() + 1);
            updateGitLabProfileView(profileView);
            return summerizeView(profileView.getCount());
        } else {
            signUpNewGitLabProfileView(profile);
            return "1";
        }
    }

    private void updateGitLabProfileView(GitLabProfileView profileView) {
        try {
            gitLabProfileViewService.save(profileView);
        } catch (Exception e) {
            throw new ServerException();
        }
    }

    private void signUpNewGitLabProfileView(String profile) {
        GitLabProfileView profileView = GitLabProfileView.builder()//
                .profile(profile)//
                .count(1)//
                .build();
        try {
            gitLabProfileViewService.save(profileView);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException();
        }
    }

    private Optional<GitLabProfileView> getGitLabProfileView(String profile) {
        Optional<GitLabProfileView> profileView;
        try {
            profileView = gitLabProfileViewService.getByProfile(profile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException();
        }
        return profileView;
    }

    private String calculateGitLabRepoView(String profile, String repo) {
        Optional<GitLabRepositoryView> maybeRepoView = getGitLabRepoView(profile, repo);
        if (maybeRepoView.isPresent()) {
            GitLabRepositoryView repositoryView = maybeRepoView.get();
            repositoryView.setCount(repositoryView.getCount() + 1);
            updateGitLabRepoView(repositoryView);
            return summerizeView(repositoryView.getCount());
        } else {
            signUpNewRepoView(profile, repo);
            return "1";
        }
    }

    private void updateGitLabRepoView(GitLabRepositoryView repositoryView) {
        try {
            gitLabRepositoryViewService.save(repositoryView);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException();
        }
    }

    private void signUpNewRepoView(String profile, String repo) {
        GitLabRepositoryView repositoryView = GitLabRepositoryView.builder()//
                .profile(profile)//
                .repo(repo)//
                .count(1)//
                .build();
        try {
            gitLabRepositoryViewService.save(repositoryView);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException();
        }
    }

    private Optional<GitLabRepositoryView> getGitLabRepoView(String profile, String repo) {
        Optional<GitLabRepositoryView> repositoryView;
        try {
            repositoryView = gitLabRepositoryViewService.getByProfileAndRepo(profile, repo);
        } catch (Exception e) {
            throw new ServerException();
        }
        return repositoryView;
    }

    private String summerizeView(long views) {
        final DecimalFormat dfSharp = new DecimalFormat("#.#");
        if (views >= 1000 && views < 1000000) {
            return dfSharp.format(views / 1000D) + "K";
        } else if (views >= 1000000 && views < 1000000000) {
            return dfSharp.format(views / 1000000D) + "M";
        } else if (views >= 1000000000 && views < 1000000000000L) {
            return dfSharp.format(views / 1000000000D) + "B";
        }
        return String.valueOf(views);
    }

}
