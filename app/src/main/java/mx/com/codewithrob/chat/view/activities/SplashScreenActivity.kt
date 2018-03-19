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

    override fun showMessage(message: Int) {
        Snackbar.make(splashLayout, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun showMessage(message: String) {
        Snackbar.make(splashLayout, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun showErrorMessage(err: Int) {
        val snackbar: Snackbar = Snackbar.make(splashLayout, err, Snackbar.LENGTH_SHORT)
        snackbar.view.setBackgroundColor(resources.getColor(R.color.errorColor))
        snackbar.show()    }

    override fun showErrorMessage(err: String) {
        val snackbar: Snackbar = Snackbar.make(splashLayout, err, Snackbar.LENGTH_SHORT)
        snackbar.view.setBackgroundColor(resources.getColor(R.color.errorColor))
        snackbar.show()
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
