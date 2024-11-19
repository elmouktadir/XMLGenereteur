package ma.ensa.javaProject.Module;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void setIdUtilisateur() {
    }

    @Test
    void isPhoneNumberTest() {
        String phone = "+212708228904";
        boolean valide = Client.isPhoneNumber(phone);
        assertTrue(valide);
    }

    @Test
    void isValideEmailTest() {
        String email = "addresse@exemple.com";
        boolean valide = Client.isValideEmail(email);
        assertTrue(valide);
    }
}