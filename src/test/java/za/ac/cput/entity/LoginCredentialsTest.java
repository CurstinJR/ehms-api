package za.ac.cput.entity;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.user.LoginCredentials;

class LoginCredentialsTest {

    @Test
    public void test() {
        LoginCredentials lct = LoginCredentials.builder()
                .id(217895456)
                .email("leonash@gmail.com")
                .password("leonas7889")
                .build();
        System.out.println(lct);

        LoginCredentials lct2 = LoginCredentials.builder()
                .id(217895458)
                .email("stevenB@gmail.com")
                .password("stev7489")
                .build();
        System.out.println(lct2);

        LoginCredentials lct3 = LoginCredentials.builder()
                .id(217895554)
                .email("spencerL@gmail.com")
                .password("Lspen478")
                .build();
        System.out.println(lct3);
    }
}