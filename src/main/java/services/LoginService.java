package services;

import repository.LoginRepository;

import static config.DatabaseConfig.getConnection;

public class LoginService {
    public static String validateUser(String user, String pass) throws Exception {
        return (LoginRepository.validateUser(user, pass));
    }

}
