package automation.basic;

import org.testng.Assert;
import org.testng.annotations.Test;
import static automation.Main.kiem_tra_password;

public class PasswordTest {

        @Test
        void validPassword(){
            Assert.assertTrue(kiem_tra_password("P@ssw0rd"));
        }

        @Test
        void invalidPassword_missingNumber(){
            Assert.assertFalse(kiem_tra_password("P@ssword"));
        }

        @Test
        void invalidPassword_missingUpperCases(){
            Assert.assertFalse(kiem_tra_password("p@ssw0rd"));
        }

        @Test
        void invalidPassword_missingLowerCases(){
            Assert.assertFalse(kiem_tra_password("P@SSW0RD"));
        }

        @Test
        void invalidPassword_missingSpecialChars(){
            Assert.assertFalse(kiem_tra_password("Passw0rd"));
        }

        @Test
        void invalidPassword_less8chars(){
            Assert.assertFalse(kiem_tra_password("P@ssw0r"));
        }
}
