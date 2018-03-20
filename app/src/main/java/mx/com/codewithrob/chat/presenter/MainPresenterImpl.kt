package mx.com.codewithrob.chat.presenter

import mx.com.codewithrob.chat.R
import mx.com.codewithrob.chat.interfaces.Main
import mx.com.codewithrob.chat.model.clases.User
import mx.com.codewithrob.chat.model.interactor.MainInteractorImpl

class MainPresenterImpl(private val view: Main.View) : Main.Presenter {

    private val interactor : Main.Interactor
    private var user : User? = null

    init {
        interactor = MainInteractorImpl(this)
    }

    override fun onViewInit() {
        view.showProgressBar()
        interactor.loadCurrentUser(object : Main.UserLoadedCallback {
            override fun onComplete(user: User?) {
                this@MainPresenterImpl.user = user
                if (user != null) {
                    view.setUserInformation(user)
                    view.navigateToChatroomActivity()
                }
                else view.showErrorMessage(R.string.load_information_error)
                view.hideProgressBar()
            }
        })
    }


}