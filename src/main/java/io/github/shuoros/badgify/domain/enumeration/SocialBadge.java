package io.github.shuoros.badgify.domain.enumeration;

import io.github.shuoros.badgify.domain.model.color.HexColor;
import io.github.shuoros.badgify.domain.model.color.RgbColor;

public enum SocialBadge {
    APP_STORE("app-store", "#", HexColor.of("1588b6"), RgbColor.of(255, 255, 255)),
    BEHANCE("behance", "https://behance.net/", HexColor.of("004abf"), RgbColor.of(255, 255, 255)),
    DISCORD("discord", "https://discordapp.com/users/", HexColor.of("5253b8"), RgbColor.of(255, 255, 255)),
    DOCKERHUB("docker", "https://hub.docker.com/u/", HexColor.of("2486bb"), RgbColor.of(255, 255, 255)),
    DRIBBBLE("dribbble", "https://dribbble.com/", HexColor.of("e53f6a"), RgbColor.of(255, 255, 255)),
    DROPBOX("dropbox", "#", HexColor.of("0058c9"), RgbColor.of(255, 255, 255)),
    FACEBOOK("facebook", "https://facebook.com/", HexColor.of("374b76"), RgbColor.of(255, 255, 255)),
    GITHUB("github", "https://github.com/", HexColor.of("222145"), RgbColor.of(255, 255, 255)),
    GITLAB("gitlab", "https://gitlab.com/", HexColor.of("db3a20"), RgbColor.of(255, 255, 255)),
    GMAIL("m", "mailto://", HexColor.of("ea3c2a"), RgbColor.of(255, 255, 255)),

    GOODREADS("goodreads", "https://goodreads.com/user/show/", HexColor.of("573925"), RgbColor.of(255, 255, 255)),
    GOOGLE_DRIVE("google-drive", "#", HexColor.of("ea3c2a"), RgbColor.of(255, 255, 255)),
    GOOGLE_PLAY("google-play", "#", HexColor.of("ea3c2a"), RgbColor.of(255, 255, 255)),
    INSTAGRAM("instagram", "https://instagram.com/", HexColor.of("ba0063"), RgbColor.of(255, 255, 255)),
    KAGGLE("kaggle", "https://www.kaggle.com/profile/", HexColor.of("349ead"), RgbColor.of(255, 255, 255)),
    KICKSTARTER("kickstarter", "https://kickstarter.com/profile/", HexColor.of("05b85f"), RgbColor.of(255, 255, 255)),
    LINKEDIN("linkedin", "https://www.linkedin.com/in/", HexColor.of("0072b1"), RgbColor.of(255, 255, 255)),
    MEDIUM("medium", "https://medium.com/@", HexColor.of("080706"), RgbColor.of(255, 255, 255)),
    PAYPAL("paypal", "https://paypal.me/", HexColor.of("005387"), RgbColor.of(255, 255, 255)),
    PINTEREST("pinterest", "https://pinterest.com/", HexColor.of("da001a"), RgbColor.of(255, 255, 255)),
    QUORA("quora", "https://www.quora.com/", HexColor.of("b0251d"), RgbColor.of(255, 255, 255)),
    REDDIT("reddit", "https://www.reddit.com/user/", HexColor.of("ff3e20"), RgbColor.of(255, 255, 255)),
    SKYPE("skype", "https://join.skype.com/invite/", HexColor.of("0094b4"), RgbColor.of(255, 255, 255)),
    SLACK("slack", "#", HexColor.of("4a133b"), RgbColor.of(255, 255, 255)),
    SNAPCHAT("snapchat", "http://www.snapchat.com/add/", HexColor.of("f7da00"), RgbColor.of(0, 0, 0)),
    SPOTIFY("spotify", "https://open.spotify.com/user/", HexColor.of("1ed760"), RgbColor.of(0, 0, 0)),
    STACKEXCHANGE("stack-exchange", "https://meta.stackexchange.com/users/", HexColor.of("123671"), RgbColor.of(255, 255, 255)),
    STACKOVERFLOW("stack-overflow", "https://stackoverflow.com/users/", HexColor.of("f48024"), RgbColor.of(255, 255, 255)),
    STEAM("steam", "https://steamcommunity.com/profiles/", HexColor.of("2a475e"), RgbColor.of(255, 255, 255)),
    TELEGRAM("telegram", "https://t.me/", HexColor.of("1c83b3"), RgbColor.of(255, 255, 255)),
    TIKTOK("tiktok", "https://tiktok.com/@", HexColor.of("010101"), RgbColor.of(255, 255, 255)),
    TWITCH("twitch", "https://twitch.tv/", HexColor.of("913fc9"), RgbColor.of(255, 255, 255)),
    TWITTER("twitter", "https://twitter.com/", HexColor.of("1c89b5"), RgbColor.of(255, 255, 255)),
    YAHOO_MAIL("yahoo", "mailto://", HexColor.of("672a75"), RgbColor.of(255, 255, 255)),
    YOUTUBE("youtube", "https://youtube.com/", HexColor.of("f20000"), RgbColor.of(255, 255, 255));

    private String icon;

    private String link;

    private HexColor backgroundColor;

    private RgbColor fontColor;

    SocialBadge(String icon, String link, HexColor backgroundColor, RgbColor fontColor) {
        this.icon = icon;
        this.link = link;
        this.backgroundColor = backgroundColor;
        this.fontColor = fontColor;
    }

    public String getIcon() {
        return icon;
    }

    public String getLink() {
        return link;
    }

    public HexColor getBackgroundColor() {
        return backgroundColor;
    }

    public RgbColor getFontColor() {
        return fontColor;
    }
}
