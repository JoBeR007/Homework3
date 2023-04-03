package ru.urfu;

import java.util.Arrays;

public class User {
    private final String username;
    private final String email;
    private final byte[] passwordHash;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.passwordHash = password.getBytes();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User other))
            return false;
        boolean usernameEqual = (this.username == null && other.username == null)
                || (this.username != null && this.username.equals(other.username));
        boolean emailEqual = (this.email == null && other.email == null)
                || (this.email != null && this.email.equals(other.email));
        return Arrays.equals(this.passwordHash, other.passwordHash)
                && usernameEqual
                && emailEqual;
    }

    @Override
    public final int hashCode() {
        return 17 * username.hashCode() * email.hashCode()
                + Arrays.hashCode(passwordHash);
    }
}