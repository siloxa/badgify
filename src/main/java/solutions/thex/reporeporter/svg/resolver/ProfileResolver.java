package solutions.thex.reporeporter.svg.resolver;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import solutions.thex.reporeporter.svg.SvgGenerator;
import solutions.thex.reporeporter.svg.SvgResolver;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;
import java.util.Map;

@Component
public class ProfileResolver extends SvgResolver {

    @Override
    public String resolve(Map<String, String> params) throws IOException {
        String GITHUB_API_BASE_URL = "https://api.github.com/users/";
        JSONObject user = new JSONObject(WebClient.builder().build().get().uri(GITHUB_API_BASE_URL + params.get("title"))
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class)
                .block());
        System.out.println(user);
        return SvgGenerator.builder()//
                .style(params.get("style"))//
                .theme(params.get("theme"))//
                .title(user.getString("name"))//
                .link(params.get("link"))//
                .width(resolveWidth(params.get("width"), params.get("size"), user.getString("name")))//
                .color(colorResolver(params.get("color")))//
                .id(user.getString("login"))//
                .avatar(resolveAvatar(user.getString("avatar_url")))//
                .build().render();
    }

    private String resolveAvatar(String avatarUrl) throws IOException {
        URL url = new URL(avatarUrl);
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1 != (n = in.read(buf))) {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();
        String encodedString = Base64.getEncoder().encodeToString(response);
        System.out.println(encodedString);
        // "data:image/png;base64," +
        return encodedString;
    }

    @Override
    protected String resolveWidth(String width, String size, String title) {
        return String.valueOf((int) Math.ceil(title.length() * 8.6441176 + 103.05));
    }

}
