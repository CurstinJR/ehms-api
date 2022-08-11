package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.user.LoginCredentials;
import za.ac.cput.factory.user.LoginCredentialsFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LoginCredentialsFactoryTest {

    @Test
    public void test() {

        LoginCredentials login1 = LoginCredentialsFactory.
                createLogin(789941230, "Lancek@outlook.com", "lance4789");
        System.out.println(login1.toString());
        assertNotNull(login1);

        LoginCredentials login2 = LoginCredentialsFactory.
                createLogin(8745660, "michealj@gmail.com", "MichealJ1230");
        System.out.println(login2.toString());
        assertNotNull(login2);

        LoginCredentials login3 = LoginCredentialsFactory.
                createLogin(12458962, "StevenL@gmail.com", "lS1203");
        System.out.println(login3.toString());
        assertNotNull(login3);
    }

}