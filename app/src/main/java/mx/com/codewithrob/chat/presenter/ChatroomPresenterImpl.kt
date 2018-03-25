package mx.com.codewithrob.chat.presenter

import mx.com.codewithrob.chat.interfaces.Chatroom
import mx.com.codewithrob.chat.model.clases.ChatMessage
import mx.com.codewithrob.chat.model.clases.User
import mx.com.codewithrob.chat.model.enums.Message
import mx.com.codewithrob.chat.model.interactor.ChatroomInteractorImpl

class ChatroomPresenterImpl(private val view: Chatroom.View) : Chatroom.Presenter {


    private val interactor: Chatroom.Interactor
    private var channel: String? = null
    private var user : User? = null

    init {
        interactor = ChatroomInteractorImpl(this)
        interactor.loadCurrentUser()
    }

    override fun updateUser(user: User?) {
        this.user = user
    }

    override fun putChatMessages(channel: String?) {
        view.showProgressBar()
        this.channel = channel
        interactor.loadChatMessages(channel, object : Chatroom.CallbackMessagesListLoaded {
            override fun onSuccess(chatMessages: List<ChatMessage>) {
                view.updateMessagesList(chatMessages)
                view.hideProgressBar()
            }
            override fun onError(err: String?) {
                view.hideProgressBar()
                view.showMessage(Message.DATABASE_ERROR, true)
            }
        })
    }

    override fun sendMessage(message: String) {
        TODO("not implemented")
    }

}