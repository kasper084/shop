package shop.service.session;

import shop.entity.User;

import java.util.Optional;

public final class UserSession {

    private static UserSession instance;

    private Optional<User> loggedUser;

    public UserSession(Optional<User> loggedUser) {
        this.loggedUser = loggedUser;
    }

    public static void setInstance(Optional<User> loggedUser) {
        if (instance == null) {
            instance = new UserSession(loggedUser);
        }
    }

    public static UserSession getInstance() {
        return instance;
    }

    public Optional<User> getUser() {
        return loggedUser;
    }

    public void cleanSession() {
        loggedUser = null;
    }
}