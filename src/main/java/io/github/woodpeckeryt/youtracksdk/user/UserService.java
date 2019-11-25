package io.github.woodpeckeryt.youtracksdk.user;

import com.google.gson.Gson;
import io.github.woodpeckeryt.youtracksdk.transport.Transport;

public class UserService {
    private final Transport transport;
    private final Gson gson;


    public UserService(Transport transport) {
        this.transport = transport;
        gson = new Gson();
    }

    public User getMeInformation() {
        String issuePath = "/api/admin/users/me?fields=login,fullname,email,jabberAccountName,ringId,guestonline,banned,avatarUrl";
        String response = this.transport.sendGetRequest(issuePath);
        return gson.fromJson(response, User.class);
    }
}
