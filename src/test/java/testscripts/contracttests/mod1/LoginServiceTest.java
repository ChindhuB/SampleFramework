package testscripts.contracttests.mod1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import services.LoginService;
import testscripts.contracttests.BaseServiceTest;
import utility.api.BadRequest;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LoginServiceTest extends BaseServiceTest {
    String msg;
    @DisplayName("Log in valid Username,Password Schema Validation")
    @ParameterizedTest
    @Order(0)
    @CsvSource({"scsacas@gmail.com,dhgvjvrrdtrdrtdtrdtr"})
    public void valSchema(String email, String password){
    Assertions.assertTrue(new LoginService().valuserLoginSchema(email,password));
    }

    @DisplayName("Log with valid Username,Password and  Email verified")
    @ParameterizedTest
    @CsvSource({"scsacas@gmail.com,dhgvjvrrdtrdrtdtrdtr,User logged in successfully", "scsacas@gmail.com,dhgvjvrrdtrdrtdtrdtr,Your email is not verified. Please try resending the verification code if needed."})
    public void login_validUsernamePassword_verifiedEmail(String email, String password,String expmsg) {
        LoginService uLog = new LoginService();
        msg = uLog.userLoginVerify(email, password).getMessage();
        lognode.info(msg);
        Assertions.assertTrue(msg.equalsIgnoreCase(expmsg));
    }

    @DisplayName("Log with invalid Username or Password")
    @ParameterizedTest
    @MethodSource("provideParametersInvalid")
    public void login_invalidUsernamePassword(String email, String password,String expmsg) {
        BadRequest err = new BadRequest();
        msg = err.userLogin(email, password).getMessage().getEmail();
        lognode.info(msg);
        Assertions.assertTrue(msg.equalsIgnoreCase(expmsg));

    }

    @DisplayName("Log with valid Username,Password and  Email not verified")
    @ParameterizedTest
    @MethodSource("provideParametersValidNonverifiedEmail")
    public void login_validUsernamePassword_nonverifiedEmail(String email, String password,String expmsg) {
        LoginService uLog = new LoginService();
        msg = uLog.userLoginVerify(email, password).getMessage();
        lognode.info(msg);
        Assertions.assertTrue(msg.equalsIgnoreCase(expmsg));

    }

    private static Stream<Arguments> provideParametersInvalid() {
        return Stream.of(
                arguments("xbhii@gmail.com", "dhgvjvrrdtrdrtdtrdtr","Please enter a correct username and password. Note that the password is case-sensitive"),
                arguments("hkhklj@gmail.com", "hvhbk3443","Please enter a correct username and password. Note that the password is case-sensitive")
        );
    }

    private static Stream<Arguments> provideParametersValidNonverifiedEmail() {
        return Stream.of(
                arguments("scsacas@gmail.com", "dhgvjvrrdtrdrtdtrdtr","Your email is not verified. Please try resending the verification code if needed.")
        );
    }
}
