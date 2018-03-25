package mx.com.codewithrob.chat.presenter

import mx.com.codewithrob.chat.interfaces.Main
import mx.com.codewithrob.chat.model.clases.User
import mx.com.codewithrob.chat.model.enums.Message
import mx.com.codewithrob.chat.model.interactor.MainInteractorImpl

class MainPresenterImpl(private val view: Main.View) : Main.Presenter {

    private val interactor : Main.Interactor
    private var user : User? = null

    init {
        interactor = MainInteractorImpl(this)
    }

    override fun onViewInit() {
        view.showProgressBar()
        interactor.loadCurrentUser()
    }

    override fun updateUser(user: User?) {
        this.user = user
        if (user != null) {
            view.setUserInformation(user)
            view.navigateToChatroomActivity()
        } else view.showMessage(Message.DATABASE_ERROR, true)
        view.hideProgressBar()
    }


}