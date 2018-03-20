package mx.com.codewithrob.chat.interfaces

import mx.com.codewithrob.chat.model.clases.Message

interface Chatroom {

    interface View : BaseView {
        fun showFileTypeSelector()
        fun hideFileTypeSelector()
    }

    interface Presenter {
        fun putChatMessages(channel: String?)
        fun sendMessage(message: String)
    }

    interface Interactor {
        fun loadChatMessages(channel: String?, callback: CallbackMessagesListLoaded)
        fun saveMessage(message: String, callback: CallbackDataSaved)
    }

    interface CallbackMessagesListLoaded {
        fun onSuccess(messages: List<Message>)
        fun onError(err: String?)
    }

    interface CallbackDataSaved {
        fun onSuccess()
        fun onError(err: String?)
    }

}