package mx.com.codewithrob.chat.view.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import mx.com.codewithrob.chat.R
import mx.com.codewithrob.chat.interfaces.Login
import kotlinx.android.synthetic.main.activity_login.*
import mx.com.codewithrob.chat.presenter.LoginPresenterImpl

class LoginActivity : AppCompatActivity(), Login.View {

    private lateinit var presenter: Login.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenterImpl(this)
        loginFacebookButton.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
        presenter.initialiceFacebookButton(loginFacebookButton)
    }

    override fun showProgressBar() {
        loginProgressbar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        loginProgressbar.visibility = View.INVISIBLE
    }

    override fun getActivity(): AppCompatActivity {
        return this
    }

    override fun showMessage(message: Int) {
        Snackbar.make(loginLayout, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun showMessage(message: String) {
        Snackbar.make(loginLayout, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun navigateToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun showErrorMessage(err: Int) {
        val snackbar: Snackbar = Snackbar.make(loginLayout, err, Snackbar.LENGTH_SHORT)
        snackbar.view.setBackgroundColor(resources.getColor(R.color.errorColor))
        snackbar.show()
    }

    override fun showErrorMessage(err: String) {
        val snackbar: Snackbar = Snackbar.make(loginLayout, err, Snackbar.LENGTH_SHORT)
        snackbar.view.setBackgroundColor(resources.getColor(R.color.errorColor))
        snackbar.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onActivityResult(requestCode, resultCode, data)
    }

}
