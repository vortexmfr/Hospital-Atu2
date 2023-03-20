package serviceimpl;

import repository.LoginRepository;
import repository.PersonaRepository;

public class LoginServiceImpl {

    private static LoginRepository loginRepository;
    public String validateUser(String user, String pass) throws Exception {
        return (loginRepository.validateUser(user, pass));
    }

}
