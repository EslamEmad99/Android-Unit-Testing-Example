package eslam.emad.androidunittesting

object Util {

    private val names = listOf("Eslam", "Emad")
    private val specialCharacters = listOf<Char>('?', '!', '@', '#', '$', '%', '&', '*')

    /**
     * ## Rules :
     * 1. userName must be bigger than 2 digits
     * 2. userName must not to be repeated
     * 3. password must be bigger than 5 digits
     * 4. password and passwordConfirmation must be the same
     */
    fun register(
            userName: String,
            password: String,
            passwordConfirmation: String
    ): Boolean {
        return when {
            userName.count { it.isLetter() } <= 2 -> {
                false
            }
            userName in names -> {
                false
            }
            password.length <= 5 -> {
                false
            }
            password != passwordConfirmation -> {
                false
            }
            else -> {
                true
            }
        }
    }

    /**
     * ## Invalid password is :
     * 1. have at least 3 capital letters
     * 2. have at least 3 small letters
     * 3. have at least 3 number digits
     * 4. have at least 3 special characters
     */
    fun passwordValidation(password: String): Boolean {
        return when {
            password.count { it.isUpperCase() } < 3 -> {
                false
            }
            password.count { it.isLowerCase() } < 3 -> {
                false
            }
            password.count { it.isDigit() } < 3 -> {
                false
            }
            password.count { it in specialCharacters } < 3 -> {
                false
            }
            else -> {
                true
            }
        }
    }
}