package utility.api;

import models.api.BadRequestError;
import services.AuthService;

public class BadRequest extends AuthService {
    public BadRequestError userLogin(String email, String pswd)  {

        return Authorize(email, pswd).jsonPath().getObject(".", BadRequestError.class);

    }
}
