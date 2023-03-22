package serviceimpl;

import repository.LoginRepository;

public class LoginServiceImpl {
    public static String validateUser(String user, String pass) throws Exception {
        return (LoginRepository.validateUser(user, pass));
    }

}
