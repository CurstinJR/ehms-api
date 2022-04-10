package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.LoginCredentials;
import za.ac.cput.factory.LoginCredentialsFactory;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LoginCredentialsRepositoryTest
{
    private static LoginCredentialsRepository loginCredentialsRepository =
            LoginCredentialsRepository.getLoginCredentialsRepository();

    private static LoginCredentials user1 =
            LoginCredentialsFactory.createLogin(27899410L,"Kevinlove@gmail.com", "Hello94");

    @Test()
    @Order(1)
    void getLoginCredentialsRepository(){
        LoginCredentialsRepository loginCredentialsRepository = LoginCredentialsRepository.getLoginCredentialsRepository();
        assertEquals(loginCredentialsRepository.hashCode(), loginCredentialsRepository.hashCode());
    }

    @Test()
    @Order(2)
    void save(){
        LoginCredentials loginCredentials = loginCredentialsRepository.save(user1);
        Long id = loginCredentials.getId();
        assertEquals(id, user1.getId());
        System.out.print(loginCredentials);
    }

    @Test()
    @Order(3)
    void findById()
    {
        LoginCredentials loginCredentials = loginCredentialsRepository
                .findById(user1.getId())
                .orElseThrow();
        assertNotNull(loginCredentials);

    }

    @Test
    @Order(4)
    void findAll()
    {
        Collection<LoginCredentials> loginCredentialsList = loginCredentialsRepository.findAll();
        assertEquals(1, loginCredentialsList.size());
    }

    @Test
    @Order(5)
    void update()
    {
        Long loginCredentialsId = user1.getId();
        String email = user1.getEmail();

        user1.setEmail("quinn@email.com");
        LoginCredentials updateLoginCredentials = loginCredentialsRepository.update(user1);

        assertEquals(loginCredentialsId, updateLoginCredentials.getId());
        assertNotEquals(email, updateLoginCredentials.getEmail());
        assertEquals(user1, updateLoginCredentials);
    }

    @Test
    @Order(6)
    void existsById()
    {
        boolean vitalsExists = loginCredentialsRepository.existsById(user1.getId());

        assertTrue(vitalsExists);
    }

    @Test
    @Order(7)
    void deleteById() {
        loginCredentialsRepository.deleteById(user1.getId());

        assertTrue(loginCredentialsRepository.findAll().isEmpty());
    }
}