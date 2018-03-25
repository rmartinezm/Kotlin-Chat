package mx.com.codewithrob.chat.model.interactor

import mx.com.codewithrob.chat.interfaces.Chatroom
import mx.com.codewithrob.chat.model.clases.User
import mx.com.codewithrob.chat.model.services.FirebaseDatabaseService
import mx.com.codewithrob.chat.model.services.FirebaseDatabaseService.DataLoadedCallback

class ChatroomInteractorImpl(private val presenter: Chatroom.Presenter): Chatroom.Interactor {

    override fun loadCurrentUser() {
        FirebaseDatabaseService.loadCurrentUser(object : DataLoadedCallback<User> {
            override fun onComplete(result: User?) {
                presenter.updateUser(result)
            }
        })
    }

    override fun loadChatMessages(channel: String?, callback: Chatroom.CallbackMessagesListLoaded) {
        callback.onSuccess(ArrayList())
    }

    override fun saveMessage(message: String, callback: Chatroom.CallbackDataSaved) {
        TODO("not implemented")
    }


}