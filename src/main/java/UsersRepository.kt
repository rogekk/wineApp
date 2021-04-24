import java.util.*

class UsersRepository {
    val users = mutableMapOf<String, User>()

    fun logIn(username: String, password: String): User? {
        return users.get(username + ":" + password)
    }

    fun signUp(signupDetails: Signup) {
        users.set(signupDetails.username + ":" + signupDetails.password, User(signupDetails.username))
    }
}
