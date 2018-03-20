package mx.com.codewithrob.chat.presenter

import mx.com.codewithrob.chat.interfaces.Chatroom
import mx.com.codewithrob.chat.model.clases.Message
import mx.com.codewithrob.chat.model.clases.User
import mx.com.codewithrob.chat.model.interactor.ChatroomInteractorImpl

class ChatroomPresenterImpl(private val view: Chatroom.View) : Chatroom.Presenter {

    private val interactor: Chatroom.Interactor
    private var channel: String?
    private var user : User?

    init {
        interactor = ChatroomInteractorImpl(this)
        channel = null
        user = null
    }

    override fun putChatMessages(channel: String?) {
        view.showProgressBar()
        this.channel = channel
        interactor.loadChatMessages(channel, object : Chatroom.CallbackMessagesListLoaded {
            override fun onSuccess(messages: List<Message>) {
                TODO("not implemented")
            }

            override fun onError(err: String?) {
                TODO("not implemented")
            }
        })
    }

    override fun sendMessage(message: String) {
        TODO("not implemented")
    }

}