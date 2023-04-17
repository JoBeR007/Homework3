package ru.urfu;

import java.util.Arrays;
import java.util.Objects;

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username)
                && Objects.equals(email, user.email)
                && Arrays.equals(passwordHash, user.passwordHash);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(username, email);
        result = 31 * result + Arrays.hashCode(passwordHash);
        return result;
    }
}