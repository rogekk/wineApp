enum class MeadTypes{
    półtorak, dwójniak, trójniak, czwórniak
}
enum class AlcoholType{
    wine, mead, brew
}

data class Login(val username: String, val password: String)
data class Signup(val username: String, val password: String)

data class User(val name: String)