package solutions.thex.reporeporter.svg.resolver.badge;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import solutions.thex.reporeporter.svg.SvgResolver;
import solutions.thex.reporeporter.svg.generator.badge.ProfileGenerator;
import solutions.thex.reporeporter.svg.resolver.badge.util.ColorResolver;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;
import java.util.Map;

/**
 * An implementation of {@link solutions.thex.reporeporter.svg.SvgResolver} which resolves given parameters by user to
 * a {@link solutions.thex.reporeporter.svg.generator.badge.ProfileGenerator} instance.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
public class ProfileResolver extends SvgResolver {

    @Override
    public String resolve(Map<String, String> params) throws IOException {
        final String bg = resolveBG(params.get("bg"));
        JSONObject user = retrieveUserProfile(params.get("id"));

        return ProfileGenerator.builder()//
                .theme(params.get("theme"))//
                .title(resolveTitle(user))//
                .link(resolveLink(params.get("id")))//
                .width(resolveWidth(params.get("size"), idOrNameToResolveWidth(params.get("id"), user.getString("name"))))//
                .bg(bg)//
                .color(resolveColor(params.get("color"), bg))//
                .id(user.getString("login"))//
                .avatar(resolveAvatar(user.getString("avatar_url")))//
                .build().render();
    }

    private String idOrNameToResolveWidth(String id, String name) {
        if (id.length() > name.length())
            return "@" + id;
        return name;
    }

    private String resolveLink(String id) {
        return "https://github.com/" + id;
    }

    private JSONObject retrieveUserProfile(String id) {
        String GITHUB_API_BASE_URL = "https://api.github.com/users/";
        return new JSONObject(WebClient.builder().build().get().uri(GITHUB_API_BASE_URL + id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class)
                .block());
    }

    private String resolveTitle(JSONObject user) {
        if (user.has("name"))
            return user.getString("name");
        else
            return user.getString("login");
    }

    private String resolveAvatar(String avatarUrl) throws IOException {
        byte[] response = downloadAvatar(avatarUrl);
        return Base64.getEncoder().encodeToString(response);
    }

    private byte[] downloadAvatar(String avatarUrl) throws IOException {
        URL url = new URL(avatarUrl);
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        readInputStream(in, out);
        return out.toByteArray();
    }

    private void readInputStream(InputStream in, ByteArrayOutputStream out) throws IOException {
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1 != (n = in.read(buf))) {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
    }

    @Override
    protected String resolveWidth(String size, String title) {
        return String.valueOf((int) Math.ceil(title.length() * 8.6441176 + 103.05));
    }

}
