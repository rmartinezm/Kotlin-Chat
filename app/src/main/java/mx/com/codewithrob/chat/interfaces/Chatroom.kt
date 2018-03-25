package mx.com.codewithrob.chat.interfaces

import mx.com.codewithrob.chat.model.clases.ChatMessage
import mx.com.codewithrob.chat.model.clases.User

interface Chatroom {

    interface View : BaseView {
        fun showFileTypeSelector()
        fun hideFileTypeSelector()
        fun updateMessagesList(list: List<ChatMessage>)
        fun addNewMessage(chatMessage: ChatMessage)
    }

    interface Presenter {
        fun updateUser(user: User?)
        fun putChatMessages(channel: String?)
        fun sendMessage(message: String)
    }

    interface Interactor {
        fun loadCurrentUser()
        fun loadChatMessages(channel: String?, callback: CallbackMessagesListLoaded)
        fun saveMessage(message: String, callback: CallbackDataSaved)
    }

    interface CallbackMessagesListLoaded {
        fun onSuccess(chatMessages: List<ChatMessage>)
        fun onError(err: String?)
    }

    interface CallbackDataSaved {
        fun onSuccess()
        fun onError(err: String?)
    }

}