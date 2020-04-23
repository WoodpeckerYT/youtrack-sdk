package io.github.woodpeckeryt.youtracksdk;

import io.github.woodpeckeryt.youtracksdk.entities.YouTrack;
import io.github.woodpeckeryt.youtracksdk.user.User;
import io.github.woodpeckeryt.youtracksdk.user.UserFields;
import io.github.woodpeckeryt.youtracksdk.user.UserService;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicStatusLine;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserMethodsTest extends YouTrackProvider {
    private final static Logger logger = LoggerFactory.getLogger(UserMethodsTest.class);

    @Test
    public void getUserInformation() throws IOException {
        YouTrack youTrack = super.get();

        UserService userService = youTrack.getUserService();

        Optional<User> user = userService.getMeInformation(UserFields.FULL_NAME.getFieldName(), UserFields.LOGIN.getFieldName());

        String login = user.isPresent() ? user.get().getLogin() : "";
        logger.debug("Received from YT user with login {}", login);

        assertEquals("rinat.muhamedgaliev", login);
    }

    @Mocked
    private CloseableHttpClient client;

    @Mocked
    private CloseableHttpResponse response;

    @Mocked
    private HttpUriRequest request;

    @Test
    public void getUserInformationWithError() throws IOException {
        YouTrack youTrack = super.get();

        UserService userService = youTrack.getUserService();

        new Expectations() {{
            client.execute((HttpUriRequest) any);
            result = response;
        }};

        new Expectations() {{
            response.getStatusLine();
            result = new BasicStatusLine(
                new ProtocolVersion("HTTP", 1, 1),
                401,
                "Unauthorized"
            );
        }};

        new MockUp<HttpClients>() {

            @Mock
            CloseableHttpClient createDefault() {
                return client;
            }
        };

        assertThrows(IOException.class, () -> userService.getMeInformation(UserFields.FULL_NAME.getFieldName(), UserFields.LOGIN.getFieldName()));
    }
}
