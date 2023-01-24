package solutions.thex.badgify.control.ready;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SocialBadgeControllerTests {

    @Value("${server.port}")
    private int port;

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private Filter springSecurityFilterChain;

    String host = "http://localhost:" + port;

    @BeforeAll
    void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilters(springSecurityFilterChain).build();
    }

    @Test
    void appStoreSocialBadgeMustGenerateALTRLinkBadgeWithAppStoreIcon() throws Exception {
        // Given
        String uri = host + "/api/social/app-store/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/app-store.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void behanceSocialBadgeMustGenerateALTRLinkBadgeWithBehanceIcon() throws Exception {
        // Given
        String uri = host + "/api/social/behance/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/behance.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void discordSocialBadgeMustGenerateALTRLinkBadgeWithDiscordIcon() throws Exception {
        // Given
        String uri = host + "/api/social/discord/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/discord.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void dockerHubSocialBadgeMustGenerateALTRLinkBadgeWithDockerHubIcon() throws Exception {
        // Given
        String uri = host + "/api/social/dockerhub/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/dockerhub.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void dribbbleSocialBadgeMustGenerateALTRLinkBadgeWithDribbbleIcon() throws Exception {
        // Given
        String uri = host + "/api/social/dribbble/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/dribbble.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void dropboxSocialBadgeMustGenerateALTRLinkBadgeWithDropboxIcon() throws Exception {
        // Given
        String uri = host + "/api/social/dropbox/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/dropbox.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void facebookSocialBadgeMustGenerateALTRLinkBadgeWithFacebookIcon() throws Exception {
        // Given
        String uri = host + "/api/social/facebook/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/facebook.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void githubSocialBadgeMustGenerateALTRLinkBadgeWithGithubIcon() throws Exception {
        // Given
        String uri = host + "/api/social/github/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/github.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void gitlabSocialBadgeMustGenerateALTRLinkBadgeWithGitlabIcon() throws Exception {
        // Given
        String uri = host + "/api/social/gitlab/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/gitlab.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void goodReadsSocialBadgeMustGenerateALTRLinkBadgeWithGoodReadsIcon() throws Exception {
        // Given
        String uri = host + "/api/social/goodreads/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/goodreads.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void googleDriveSocialBadgeMustGenerateALTRLinkBadgeWithGoogleDriveIcon() throws Exception {
        // Given
        String uri = host + "/api/social/google-drive/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/google-drive.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void googlePlaySocialBadgeMustGenerateALTRLinkBadgeWithGooglePlayIcon() throws Exception {
        // Given
        String uri = host + "/api/social/google-play/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/google-play.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void instagramSocialBadgeMustGenerateALTRLinkBadgeWithInstagramIcon() throws Exception {
        // Given
        String uri = host + "/api/social/instagram/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/instagram.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void kaggleSocialBadgeMustGenerateALTRLinkBadgeWithKaggleIcon() throws Exception {
        // Given
        String uri = host + "/api/social/kaggle/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/kaggle.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void kickstarterSocialBadgeMustGenerateALTRLinkBadgeWithKickstarterIcon() throws Exception {
        // Given
        String uri = host + "/api/social/kickstarter/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/kickstarter.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void linkedinSocialBadgeMustGenerateALTRLinkBadgeWithLinkedinIcon() throws Exception {
        // Given
        String uri = host + "/api/social/linkedin/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/linkedin.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void mediumSocialBadgeMustGenerateALTRLinkBadgeWithMediumIcon() throws Exception {
        // Given
        String uri = host + "/api/social/medium/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/medium.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void paypalSocialBadgeMustGenerateALTRLinkBadgeWithPaypalIcon() throws Exception {
        // Given
        String uri = host + "/api/social/paypal/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/paypal.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void pinterestSocialBadgeMustGenerateALTRLinkBadgeWithPinterestIcon() throws Exception {
        // Given
        String uri = host + "/api/social/pinterest/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/pinterest.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void quoraSocialBadgeMustGenerateALTRLinkBadgeWithQuoraIcon() throws Exception {
        // Given
        String uri = host + "/api/social/quora/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/quora.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void redditSocialBadgeMustGenerateALTRLinkBadgeWithRedditIcon() throws Exception {
        // Given
        String uri = host + "/api/social/reddit/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/reddit.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void skypeSocialBadgeMustGenerateALTRLinkBadgeWithSkypeIcon() throws Exception {
        // Given
        String uri = host + "/api/social/skype/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/skype.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void slackSocialBadgeMustGenerateALTRLinkBadgeWithSlackIcon() throws Exception {
        // Given
        String uri = host + "/api/social/slack/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/slack.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void snapchatSocialBadgeMustGenerateALTRLinkBadgeWithSnapchatIcon() throws Exception {
        // Given
        String uri = host + "/api/social/snapchat/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/snapchat.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void spotifySocialBadgeMustGenerateALTRLinkBadgeWithSpotifyIcon() throws Exception {
        // Given
        String uri = host + "/api/social/spotify/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/spotify.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void stackExchangeSocialBadgeMustGenerateALTRLinkBadgeWithStackExchangeIcon() throws Exception {
        // Given
        String uri = host + "/api/social/stack-exchange/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/stack-exchange.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void stackoverflowSocialBadgeMustGenerateALTRLinkBadgeWithStackoverflowIcon() throws Exception {
        // Given
        String uri = host + "/api/social/stackoverflow/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/stackoverflow.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void steamSocialBadgeMustGenerateALTRLinkBadgeWithSteamIcon() throws Exception {
        // Given
        String uri = host + "/api/social/steam/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/steam.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void telegramSocialBadgeMustGenerateALTRLinkBadgeWithTelegramIcon() throws Exception {
        // Given
        String uri = host + "/api/social/telegram/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/telegram.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void tiktokSocialBadgeMustGenerateALTRLinkBadgeWithTiktokIcon() throws Exception {
        // Given
        String uri = host + "/api/social/tiktok/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/tiktok.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void tumblrSocialBadgeMustGenerateALTRLinkBadgeWithTumblrIcon() throws Exception {
        // Given
        String uri = host + "/api/social/tumblr/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/tumblr.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void twitchSocialBadgeMustGenerateALTRLinkBadgeWithTwitchIcon() throws Exception {
        // Given
        String uri = host + "/api/social/twitch/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/twitch.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void twitterSocialBadgeMustGenerateALTRLinkBadgeWithTwitterIcon() throws Exception {
        // Given
        String uri = host + "/api/social/twitter/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/twitter.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void yahooMailSocialBadgeMustGenerateALTRLinkBadgeWithYahooMailIcon() throws Exception {
        // Given
        String uri = host + "/api/social/yahoo-mail/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/yahoo-mail.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void youtubeSocialBadgeMustGenerateALTRLinkBadgeWithYoutubeIcon() throws Exception {
        // Given
        String uri = host + "/api/social/youtube/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/ready/social/youtube.svg"));
        assertEquals(orgBadge, content);
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

}
