package cu.edu.cujae.structdb.services;

import cu.edu.cujae.structdb.dto.model.UserDTO;

public class AuthService {
    public enum LoginResult { correct, wrongUsername, wrongPassword };
    private UserDTO currentUser;

    private LoginResult login(UserDTO credentials) {
        UserDTO response = ServicesLocator.UserServices().getByUsername(credentials.getUsername());

        if (response == null) {
            return LoginResult.wrongUsername;
        }

        if (!response.getPassword().equals(credentials.getPassword())) {
            return LoginResult.wrongPassword;
        }

        currentUser = response;
        return LoginResult.correct;
    }
}

