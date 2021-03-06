package com.example.winemakerapp

import Database
import UserLoginData
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Signup : AppCompatActivity(), SignUpPresenter.View {


    val presenter by lazy {
    SignUpPresenter(Database(getSharedPreferences("myPrefs", Context.MODE_PRIVATE)))
    }

    lateinit var errorView: TextView
    lateinit var successView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        errorView = findViewById<TextView>(R.id.errorView)
        successView = findViewById<TextView>(R.id.successView)

        presenter.attachView(this)

        findViewById<View>(R.id.submit).setOnClickListener {

            val username = findViewById<EditText>(R.id.username).text.toString()
            val password = findViewById<EditText>(R.id.password).text.toString()
            presenter.signUp(username, password)

        }
    }

    override fun goToOtherScreen() {
        TODO("Not yet implemented")
    }

    override fun showEmptyUsername() {

        errorView.setVisibility(View.VISIBLE)
        errorView.setText("Please insert your user name")
    }

    override fun showSuccess(data: UserLoginData?) {
        successView.setVisibility(View.VISIBLE)
        successView.setText("Successful sign in: username: ${data?.username}, password: ${data?.password}")
    }

    override fun clearErrors() {
        errorView.setVisibility(View.GONE)
    }

}


class SignUpPresenter(val database: Database) {


    lateinit var view: SignUpPresenter.View

    fun attachView(view: SignUpPresenter.View) {
        this.view = view
    }

    fun signUp(username: String, password: String) {
        if (username.isEmpty()) {
            view.showEmptyUsername()
        } else {
            view.clearErrors()
        }
        if (username.isNotEmpty() && password.isNotEmpty()) {
            database.insert(UserLoginData(username, password))
            view.showSuccess(database.selectByUsername(username))
        }
    }

    interface View {
        fun goToOtherScreen()
        fun showEmptyUsername()
        fun showSuccess(data: UserLoginData?)
        fun clearErrors()
    }
}

