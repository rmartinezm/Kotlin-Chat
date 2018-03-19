package mx.com.codewithrob.chat.interfaces

import mx.com.codewithrob.chat.model.clases.User

interface Main {

    interface View : BaseView {
        fun setUserInformation(user: User)
        fun navigateToChatroomActivity()
    }

    interface Presenter {
        fun onViewInit()
    }

    interface Interactor {
        fun loadCurrentUser(callback: UserLoadedCallback)
    }

    interface UserLoadedCallback {
        fun onComplete(user: User?)
    }

}