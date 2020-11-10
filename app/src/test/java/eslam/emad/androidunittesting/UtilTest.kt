package eslam.emad.androidunittesting

import com.google.common.truth.Truth.assertThat
import eslam.emad.androidunittesting.Util.passwordValidation
import eslam.emad.androidunittesting.Util.register
import org.junit.Test

class UtilTest{
    
    @Test
    fun `register() with empty userName then return false`(){

        // arrange
        val userName = ""
        val password = "123456"
        val passwordConfirmation = "123456"

        // act
        val result = register(userName, password, passwordConfirmation)

        //assert
        assertThat(result).isFalse()
    }

    @Test
    fun `register() with userName contains spaces then return false`(){

        // arrange
        val userName = "    "
        val password = "123456"
        val passwordConfirmation = "123456"

        // act
        val result = register(userName, password, passwordConfirmation)

        //assert
        assertThat(result).isFalse()
    }

    @Test
    fun `register() with userName 2 digits then return false`(){

        // arrange
        val userName = "ab"
        val password = "123456"
        val passwordConfirmation = "123456"

        // act
        val result = register(userName, password, passwordConfirmation)

        //assert
        assertThat(result).isFalse()
    }

    @Test
    fun `register() with repeated userName then return false`(){

        // arrange
        val userName = "Eslam"
        val password = "123456"
        val passwordConfirmation = "123456"

        // act
        val result = register(userName, password, passwordConfirmation)

        //assert
        assertThat(result).isFalse()
    }

    @Test
    fun `register() with empty password then return false`(){

        // arrange
        val userName = "Khalid"
        val password = ""
        val passwordConfirmation = ""

        // act
        val result = register(userName, password, passwordConfirmation)

        //assert
        assertThat(result).isFalse()
    }

    @Test
    fun `register() with password 5 digits then return false`(){

        // arrange
        val userName = "Khalid"
        val password = "12345"
        val passwordConfirmation = "12345"

        // act
        val result = register(userName, password, passwordConfirmation)

        //assert
        assertThat(result).isFalse()
    }

    @Test
    fun `register() with password and passwordConfirmation not equal then return false`(){

        // arrange
        val userName = "Ahmed"
        val password = "123456"
        val passwordConfirmation = "123457"

        // act
        val result = register(userName, password, passwordConfirmation)

        //assert
        assertThat(result).isFalse()
    }

    @Test
    fun `register() with userName bigger than 2 digits and password and passwordConfirmation bigger than 5 and equal then return true`(){

        // arrange
        val userName = "Alaa"
        val password = "123456"
        val passwordConfirmation = "123456"

        // act
        val result = register(userName, password, passwordConfirmation)

        //assert
        assertThat(result).isTrue()
    }

    @Test
    fun `passwordValidation() with empty password then return false`(){
        // arrange
        val password = "     "

        // act
        val result = passwordValidation(password)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun `passwordValidation() without capital letters then return false`(){
        // arrange
        val password = "abc123?!@#"

        // act
        val result = passwordValidation(password)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun `passwordValidation() without small letters then return false`(){
        // arrange
        val password = "ABC123?!@#"

        // act
        val result = passwordValidation(password)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun `passwordValidation() without numbers then return false`(){
        // arrange
        val password = "abcABC?!@#"

        // act
        val result = passwordValidation(password)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun `passwordValidation() without special characters then return false`(){
        // arrange
        val password = "abc123ABC"

        // act
        val result = passwordValidation(password)

        // assert
        assertThat(result).isFalse()
    }

    @Test
    fun `passwordValidation() with valid password then return true`(){
        // arrange
        val password = "abcdfgAAVVABC124563?!$%@#يسبيل"

        // act
        val result = passwordValidation(password)

        // assert
        assertThat(result).isTrue()
    }
}