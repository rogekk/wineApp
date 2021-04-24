import android.content.SharedPreferences


class Database(private val sharedPreferences: SharedPreferences) {


    fun insert(userLoginData: UserLoginData) {
        val editor = sharedPreferences.edit()
        editor.putString(userLoginData.username, "${userLoginData.username},${userLoginData.password}")
        editor.apply()
    }


    fun selectByUsername(username: String): UserLoginData? {
        val usernameAndPassword: List<String>? = sharedPreferences.getString(username, null)?.split(",")
        if (usernameAndPassword == null) return null
        return UserLoginData(usernameAndPassword.get(0), usernameAndPassword.get(1))
    }
}
