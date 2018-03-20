package mx.com.codewithrob.chat.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import mx.com.codewithrob.chat.R
import mx.com.codewithrob.chat.interfaces.Chatroom
import kotlinx.android.synthetic.main.activity_chatroom.*
import mx.com.codewithrob.chat.presenter.ChatroomPresenterImpl

class ChatroomActivity : AppCompatActivity(), Chatroom.View {

    private lateinit var presenter: Chatroom.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatroom)
        presenter = ChatroomPresenterImpl(this)
    }

    override fun showFileTypeSelector() {
        TODO("not implemented")
    }

    override fun hideFileTypeSelector() {
        TODO("not implemented")
    }

    override fun showProgressBar() {
        chatroomProgressbar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        chatroomProgressbar.visibility = View.INVISIBLE
    }

    override fun showMessage(message: Int) {
        Snackbar.make(chatroomLayout, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun showMessage(message: String) {
        Snackbar.make(chatroomLayout, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun showErrorMessage(err: Int) {
        val snackbar: Snackbar = Snackbar.make(chatroomLayout, err, Snackbar.LENGTH_SHORT)
        snackbar.view.setBackgroundColor(resources.getColor(R.color.errorColor))
        snackbar.show()
    }

    override fun showErrorMessage(err: String) {
        val snackbar: Snackbar = Snackbar.make(chatroomLayout, err, Snackbar.LENGTH_SHORT)
        snackbar.view.setBackgroundColor(resources.getColor(R.color.errorColor))
        snackbar.show()
    }
}
