package io.github.woodpeckeryt.youtracksdk.user;

public enum UserFields {
    LOGIN("login"),
    FULL_NAME("full_name"),
    EMAIL("email"),
    RING_ID("ringId"),
    GUEST_ONLINE("guestonline"),
    BANNED("banned"),
    AVATAR("avatarUrl");

    private final String fieldName;

    private UserFields(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return this.fieldName;
    }
}
