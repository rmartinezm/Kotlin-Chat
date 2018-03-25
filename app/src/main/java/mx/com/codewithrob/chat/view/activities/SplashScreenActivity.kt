package mx.com.codewithrob.chat.view.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.view.View
import mx.com.codewithrob.chat.R
import mx.com.codewithrob.chat.interfaces.SplashScreen
import mx.com.codewithrob.chat.presenter.SplashScreenPresenterImpl
import kotlinx.android.synthetic.main.activity_splash_screen.*
import mx.com.codewithrob.chat.model.enums.Message

class SplashScreenActivity : AppCompatActivity(), SplashScreen.View {

    private lateinit var presenter: SplashScreen.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        presenter = SplashScreenPresenterImpl(this)
        Handler().postDelayed({ presenter.verifyLogin() }, 1500)
    }

    override fun showProgressBar() {
        splashProgressbar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        splashProgressbar.visibility = View.INVISIBLE
    }

    override fun showMessage(message: Message, err: Boolean) {
        val snackbar: Snackbar? = when(message){
            Message.INTERNET_ERROR -> Snackbar.make(splashLayout, R.string.internet_error, Snackbar.LENGTH_SHORT)
            else -> null
        }
        if (err) snackbar?.view?.setBackgroundColor(resources.getColor(R.color.errorColor))
        snackbar?.show()
    }

    override fun navigateToLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun navigateToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
