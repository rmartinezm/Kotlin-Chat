package mx.com.codewithrob.chat.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.bumptech.glide.Glide
import mx.com.codewithrob.chat.R
import kotlinx.android.synthetic.main.activity_main.*
import mx.com.codewithrob.chat.interfaces.Main
import mx.com.codewithrob.chat.model.clases.User
import mx.com.codewithrob.chat.presenter.MainPresenterImpl

class MainActivity : AppCompatActivity(), Main.View {

    private lateinit var presenter : Main.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenterImpl(this)
        presenter.onViewInit()
    }

    override fun showProgressBar() {
        mainProgressbar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        mainProgressbar.visibility = View.INVISIBLE
    }

    override fun setUserInformation(user: User) {
        Glide.with(this).load(user.photoURL).into(ivProfilePicture)
        tvUserName.text = user.username
    }

    override fun navigateToChatroomActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(message: Int) {
        Snackbar.make(mainLayout, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun showMessage(message: String) {
        Snackbar.make(mainLayout, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun showErrorMessage(err: Int) {
        val snackbar: Snackbar = Snackbar.make(mainLayout, err, Snackbar.LENGTH_SHORT)
        snackbar.view.setBackgroundColor(resources.getColor(R.color.errorColor))
        snackbar.show()
    }

    override fun showErrorMessage(err: String) {
        val snackbar: Snackbar = Snackbar.make(mainLayout, err, Snackbar.LENGTH_SHORT)
        snackbar.view.setBackgroundColor(resources.getColor(R.color.errorColor))
        snackbar.show()
    }
}
