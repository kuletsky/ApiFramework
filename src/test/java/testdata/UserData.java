package testdata;

import models.request.User;

public class UserData {
    public static final User DEFAULT_USER = new User(0,
            "username",
            "firstName",
            "lastName",
            "email",
            "password",
            "phone",
            0);

    public static final User INVALID_USER = new User(0,
            null,
            null,
            null,
            null,
            null,
            null,
            0);
}
