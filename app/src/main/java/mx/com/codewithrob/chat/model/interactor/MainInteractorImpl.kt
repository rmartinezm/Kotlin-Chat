package mx.com.codewithrob.chat.model.interactor

import mx.com.codewithrob.chat.interfaces.Main
import mx.com.codewithrob.chat.model.clases.User
import mx.com.codewithrob.chat.model.services.FirebaseDatabaseService
import mx.com.codewithrob.chat.model.services.FirebaseDatabaseService.DataLoadedCallback

class MainInteractorImpl(private val presenter: Main.Presenter) : Main.Interactor {

    override fun loadCurrentUser() {
        FirebaseDatabaseService.loadCurrentUser(object : DataLoadedCallback<User> {
            override fun onComplete(result: User?) {
                presenter.updateUser(result)
            }
        })
    }

}