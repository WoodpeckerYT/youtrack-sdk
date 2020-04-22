package io.github.woodpeckeryt.youtracksdk;

import io.github.woodpeckeryt.youtracksdk.entities.YouTrack;
import io.github.woodpeckeryt.youtracksdk.user.User;
import io.github.woodpeckeryt.youtracksdk.user.UserFields;
import io.github.woodpeckeryt.youtracksdk.user.UserService;
import org.apache.http.HttpStatus;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicStatusLine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@PowerMockIgnore({"com.sun.org.apache.xerces.*", "javax.xml.*", "org.xml.*", "javax.management.*", "javax.net.ssl.*"})
@RunWith(PowerMockRunner.class)
@PrepareForTest({HttpClients.class})
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

    @Test(expected = IOException.class)
    public void getUserInformationWithError() throws IOException {
        YouTrack youTrack = super.get();

        PowerMockito.mockStatic(HttpClients.class);

        UserService userService = youTrack.getUserService();

        CloseableHttpClient client = mock(CloseableHttpClient.class);
        CloseableHttpResponse response = mock(CloseableHttpResponse.class);

        when(HttpClients.createDefault()).thenReturn(client);
        when(client.execute(any(HttpUriRequest.class))).thenReturn(response);
        when(response.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("HTTP", 1, 1),
                401,
                "Unauthorized"
        ));

        Optional<User> user = userService.getMeInformation(UserFields.FULL_NAME.getFieldName(), UserFields.LOGIN.getFieldName());

        assertEquals(Optional.empty(), user);
    }
}
