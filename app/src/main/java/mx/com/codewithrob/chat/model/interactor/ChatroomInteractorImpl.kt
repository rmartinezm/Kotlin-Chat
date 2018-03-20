package mx.com.codewithrob.chat.model.interactor

import mx.com.codewithrob.chat.interfaces.Chatroom

class ChatroomInteractorImpl(private val presenter: Chatroom.Presenter): Chatroom.Interactor {

    override fun loadChatMessages(channel: String?, callback: Chatroom.CallbackMessagesListLoaded) {
        TODO("not implemented")
    }

    override fun saveMessage(message: String, callback: Chatroom.CallbackDataSaved) {
        TODO("not implemented")
    }


}