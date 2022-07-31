package solutions.thex.badgify.controller.badge.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solutions.thex.badgify.dao.GitProfileView;
import solutions.thex.badgify.dao.GitRepositoryView;
import solutions.thex.badgify.dao.service.GitProfileViewService;
import solutions.thex.badgify.dao.service.GitRepositoryViewService;
import solutions.thex.badgify.exception.ServerException;
import solutions.thex.badgify.svg.wrapper.badge.LinkAsResponseWrapper;
import solutions.thex.badgify.svg.wrapper.badge.TitleAsResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/counter")
public class ViewCounterBadgeController {

    private final GitProfileViewService profileViewService;
    private final GitRepositoryViewService repositoryViewService;
    private final LinkAsResponseWrapper linkAsResponseWrapper;

    @Autowired
    public ViewCounterBadgeController(GitProfileViewService profileViewService, //
                                      GitRepositoryViewService repositoryViewService,//
                                      LinkAsResponseWrapper linkAsResponseWrapper) {
        this.profileViewService = profileViewService;
        this.repositoryViewService = repositoryViewService;
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
        title += " " + calculateProfileView(profile);
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
        title += " " + calculateRepoView(profile, repo);
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
        title += " " + calculateProfileView(profile);
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
        title += " " + calculateRepoView(profile, repo);
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


    private String calculateProfileView(String profile) {
        Optional<GitProfileView> maybeProfileView = getProfileView(profile);
        if (maybeProfileView.isPresent()) {
            GitProfileView profileView = maybeProfileView.get();
            profileView.setCount(profileView.getCount() + 1);
            updateProfileView(profileView);
            return String.valueOf(//
                    profileView.getCount());
        } else {
            signUpNewProfileView(profile);
            return "1";
        }
    }

    private void updateProfileView(GitProfileView profileView) {
        try {
            profileViewService.save(profileView);
        } catch (Exception e) {
            throw new ServerException();
        }
    }

    private void signUpNewProfileView(String profile) {
        GitProfileView profileView = GitProfileView.builder()//
                .profile(profile)//
                .count(1)//
                .build();
        try {
            profileViewService.save(profileView);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException();
        }
    }

    private Optional<GitProfileView> getProfileView(String profile) {
        Optional<GitProfileView> profileView;
        try {
            profileView = profileViewService.getByProfile(profile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException();
        }
        return profileView;
    }

    private String calculateRepoView(String profile, String repo) {
        Optional<GitRepositoryView> maybeRepoView = getRepoView(profile, repo);
        if (maybeRepoView.isPresent()) {
            GitRepositoryView repositoryView = maybeRepoView.get();
            repositoryView.setCount(repositoryView.getCount() + 1);
            updateRepoView(repositoryView);
            return String.valueOf(//
                    repositoryView.getCount());
        } else {
            signUpNewRepoView(profile, repo);
            return "1";
        }
    }

    private void updateRepoView(GitRepositoryView repositoryView) {
        try {
            repositoryViewService.save(repositoryView);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException();
        }
    }

    private void signUpNewRepoView(String profile, String repo) {
        GitRepositoryView repositoryView = GitRepositoryView.builder()//
                .profile(profile)//
                .repo(repo)//
                .count(1)//
                .build();
        try {
            repositoryViewService.save(repositoryView);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException();
        }
    }

    private Optional<GitRepositoryView> getRepoView(String profile, String repo) {
        Optional<GitRepositoryView> repositoryView;
        try {
            repositoryView = repositoryViewService.getByProfileAndRepo(profile, repo);
        } catch (Exception e) {
            throw new ServerException();
        }
        return repositoryView;
    }

}
