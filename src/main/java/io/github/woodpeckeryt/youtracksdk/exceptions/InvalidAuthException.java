package io.github.woodpeckeryt.youtracksdk.exceptions;

import java.io.IOException;

public class InvalidAuthException extends IOException {

    public InvalidAuthException(String message) {
        super(message);
    }
}
