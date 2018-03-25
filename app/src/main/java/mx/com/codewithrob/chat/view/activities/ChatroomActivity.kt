package mx.com.codewithrob.chat.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import mx.com.codewithrob.chat.R
import mx.com.codewithrob.chat.interfaces.Chatroom
import mx.com.codewithrob.chat.model.enums.Message
import kotlinx.android.synthetic.main.activity_chatroom.*
import mx.com.codewithrob.chat.model.clases.ChatMessage
import mx.com.codewithrob.chat.presenter.ChatroomPresenterImpl

class ChatroomActivity : AppCompatActivity(), Chatroom.View {

    private lateinit var presenter: Chatroom.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatroom)
        presenter = ChatroomPresenterImpl(this)

        presenter.putChatMessages(intent.extras.getString("channnel", null))
        sendButton.setOnClickListener { presenter.sendMessage(etMessageInput.text.toString()) }
    }

    override fun showMessage(message: Message, err: Boolean) {
        val snackbar: Snackbar? =  when(message){
            Message.INTERNET_ERROR ->
                Snackbar.make(chatroomLayout, R.string.internet_error, Snackbar.LENGTH_SHORT)
            Message.DATABASE_ERROR ->
                Snackbar.make(chatroomLayout, R.string.database_error, Snackbar.LENGTH_SHORT)
            else -> null
        }
        if (err) snackbar?.view?.setBackgroundColor(resources.getColor(R.color.errorColor))
        snackbar?.show()
    }

    override fun updateMessagesList(list: List<ChatMessage>) {
        //TODO("not implemented")
    }

    override fun addNewMessage(message: ChatMessage) {
        TODO("not implemented")
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

}
