package mx.com.codewithrob.chat.model.interactor

import mx.com.codewithrob.chat.interfaces.SplashScreen

class SplashScreenInteractorImpl(presenter: SplashScreen.Presenter) : SplashScreen.Interactor {

    override fun isLogged(): Boolean {
        return true
    }
}