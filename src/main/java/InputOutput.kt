import java.util.*



class InputOutput(var scanner: Scanner) {
    private  val alcoholType = mapOf(
        "wine" to AlcoholType.wine,
        "mead" to AlcoholType.mead,
        "brew" to AlcoholType.brew)
    private val meadTypesMap = mapOf(
            "halfmead" to MeadTypes.półtorak,
        "doublemead" to MeadTypes.dwójniak,
        "triplemead" to MeadTypes.trójniak,
        "quadruplemead" to MeadTypes.czwórniak)
    fun meadOrWine(): AlcoholType? {
        println("You want to make wine or mead")
        val meadWine = scanner.nextLine()
        return alcoholType.get(meadWine)
    }
    fun whatTypOfMead(): MeadTypes? {
        val types = meadTypesMap.keys
        println("What type of mead do you want to make")
        println(types)
        val choice = scanner.nextLine()
        return meadTypesMap.get(choice)
    }
    fun whatAmountOfMeadDoYouWantToMake(): Int{
        return  scanner.nextLine().toInt()
    }
    fun getAmountOfWater(): Int {
        println("Amount of water (liters)")
        return scanner.nextLine().toInt()
    }

    fun isItMadeOutOfFruits(): Boolean {
        println("Will it be made out of fruits? (Yes/No)")
        val fruits = scanner.nextLine()
        return fruits.equals("Yes", ignoreCase = true)
    }

    fun amountOfSugarInTheFruits(): Int {
        println("Amount of sugar in the fruits (grams)")
        return scanner.nextLine().toInt()
    }
    fun desirableAmountOfAlcohol(): Int {
        println("Desirable content of alcohol")
        return scanner.nextInt()
    }

    fun getLogin(): Login {
        println("Please enter username to sign up")
        val username = scanner.nextLine()

        println("Please enter password to sign up")

        val password = scanner.nextLine()

        return Login(username, password)
    }

    fun signUp(): Signup {
        println("Welcome, please pick a username")

        val username = scanner.nextLine()

        println("Please pick a password")

        val password = scanner.nextLine()

        return Signup(username, password)
    }
    fun signupOrSignIn(): Boolean {
        println("Welcome to the WineMaker, do you want to signup or sign in?")
        val signInOrSignup = scanner.nextLine()
        return signInOrSignup.equals("signup", ignoreCase = true)
    }
}
