package eslam.emad.androidunittesting

object Util {

    private val names = listOf("Eslam", "Emad")

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
    ) : Boolean{
        return when {
            userName.count { it.isLetter() } <=2 -> {
                false
            }
            userName in names -> {
                false
            }
            password.length <=5 ->{
                false
            }
            password != passwordConfirmation ->{
                false
            }
            else -> {
                true
            }
        }
    }
}