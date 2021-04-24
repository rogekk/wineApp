import com.example.winemakerapp.src.main.java.ServiceLocator
import java.io.File
import kotlin.math.round


object Main {

    @JvmStatic
    fun main(args: Array<String>) {

        val inputOutput = ServiceLocator.inputOutput

        val signupOrSignIn = inputOutput.signupOrSignIn()
        if (signupOrSignIn) {

            //val database = Database(File("myDb"))

            val usersRepository = ServiceLocator.usersRepository

            var signupDetails = inputOutput.signUp()
            if (signupDetails.password.length < 8) {
                println("Password too short (must contain at least 8 characters)")
                signupDetails = inputOutput.signUp()
            }
            //database.insert(UserLoginData(signupDetails.username, signupDetails.password))

            usersRepository.signUp(signupDetails)
        } else {
            //val database = Database(File("myDb"))
            var loginDetails = inputOutput.getLogin()
            //val listOfAllData: List<UserLoginData> = database.selectAll()
           // while (!listOfAllData.contains(UserLoginData(loginDetails.username, loginDetails.password))) {
            //    println("Wrong username or password")
            //    loginDetails = inputOutput.getLogin()
            //    val user = loginDetails.username
            //    println("Welcome" + user)
            //}

        }
        when (inputOutput.meadOrWine()) {
            AlcoholType.mead -> {
                loop@ while (true) {
                    val meadType = inputOutput.whatTypOfMead()
                    when (meadType) {
                        MeadTypes.półtorak -> {
                            println("You choose halfmead, what amount do you want to make in liters")
                            val whatAmountOfMead = inputOutput.whatAmountOfMeadDoYouWantToMake()
                            val amountOfMead = (round(0.66 * whatAmountOfMead))
                            println("Necessary amount of honey in liters")
                            println(amountOfMead)
                            println("Necessary amount of water in liters")
                            println(whatAmountOfMead - amountOfMead)
                        }
                        MeadTypes.dwójniak -> {
                            println("You choose doublemead, what amount do you want to make in liters")
                            val whatAmountOfMead = inputOutput.whatAmountOfMeadDoYouWantToMake()
                            val amountOfMead = (whatAmountOfMead / 2.0)
                            println("Necessary amount of honey in liters")
                            println(amountOfMead)
                            println("Necessary amount of water in liters")
                            println(whatAmountOfMead - amountOfMead)
                        }
                        MeadTypes.trójniak -> {
                            println("You choose triplemead, what amount do you want to make in liters")
                            val whatAmountOfMead = inputOutput.whatAmountOfMeadDoYouWantToMake()
                            val amountOfMead = (round(whatAmountOfMead * 0.33))
                            println("Necessary amount of honey in liters")
                            println(amountOfMead)
                            println("Necessary amount of water in liters")
                            println(whatAmountOfMead - amountOfMead)
                        }
                        MeadTypes.czwórniak -> {
                            println("You choose quadruplemead, what amount do you want to make in liters")
                            val whatAmountOfMead = inputOutput.whatAmountOfMeadDoYouWantToMake()
                            val amountOfMead = (whatAmountOfMead * 0.25)
                            println("Necessary amount of honey in liters")
                            println(amountOfMead)
                            println("Necessary amount of water in liters")
                            println(whatAmountOfMead - amountOfMead)
                        }
                        else -> {
                            println("Wrong type, please write again")
                            continue@loop
                        }
                    }
                }
            }
            AlcoholType.wine -> {
                val water = inputOutput.getAmountOfWater()
                val isItMadeOutOfFruit = inputOutput.isItMadeOutOfFruits()
                if (isItMadeOutOfFruit) {
                    val amountOfSugarInTheFruits = inputOutput.amountOfSugarInTheFruits()
                    val desirableAmountOfAlcohol = inputOutput.desirableAmountOfAlcohol()
                    val result = water * desirableAmountOfAlcohol * 16 - amountOfSugarInTheFruits
                    println("Amount of sugar")
                    println(result)
                } else {
                    val result = water * inputOutput.desirableAmountOfAlcohol() * 16
                    println("Amount of sugar")
                    println(result)
                }
            }

        }
    }
}



