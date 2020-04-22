package io.github.woodpeckeryt.youtracksdk.user;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import io.github.woodpeckeryt.youtracksdk.transport.Transport;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class UserService {
    private final Transport gsonTransport;
    private final Gson gson;


    public UserService(Transport gsonTransport) {
        this.gsonTransport = gsonTransport;
        gson = new Gson();
    }

    public Optional<User> getMeInformation(String... fields) throws IOException {

        Optional<User> user = Optional.empty();

        String fieldsForRequest = mergeFields(fields);

        String issuePath = "/api/admin/users/me?fields=" + fieldsForRequest;
        String response = null;
        try {
            response = this.gsonTransport.sendGetRequest(issuePath);
            user = Optional.of(gson.fromJson(response, User.class));
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        return user;
    }

    private String mergeFields(String... fields) {
        return Arrays.stream(fields).reduce("", (partialString, field) -> {
            if (partialString.isEmpty()) {
                return partialString + field;
            } else {
                return partialString + "," + field;
            }
        });
    }
}
