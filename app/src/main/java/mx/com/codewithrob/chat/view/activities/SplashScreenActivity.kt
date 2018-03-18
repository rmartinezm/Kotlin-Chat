package mx.com.codewithrob.chat.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import mx.com.codewithrob.chat.R
import mx.com.codewithrob.chat.interfaces.SplashScreen
import mx.com.codewithrob.chat.presenter.SplashScreenPresenterImpl

class SplashScreenActivity : AppCompatActivity(), SplashScreen.View {

    private lateinit var presenter: SplashScreen.Presenter

    private lateinit var layout: View
    private lateinit var progressbar: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        presenter = SplashScreenPresenterImpl(this)
        initializeViews()
    }

    private fun initializeViews() {
        layout = findViewById(R.id.splash_layout)
        progressbar = findViewById(R.id.splash_progressbar)
    }

    override fun showProgressBar() {
        progressbar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressbar.visibility = View.INVISIBLE
    }

    override fun showMessage(message: Int) {
        Snackbar.make(layout, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun navigateToLoginActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateToMainActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
