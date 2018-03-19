package mx.com.codewithrob.chat.presenter

import mx.com.codewithrob.chat.interfaces.SplashScreen
import mx.com.codewithrob.chat.model.interactor.SplashScreenInteractorImpl

class SplashScreenPresenterImpl(private val view: SplashScreen.View) : SplashScreen.Presenter {

    private val interactor : SplashScreen.Interactor

    init {
        interactor = SplashScreenInteractorImpl(this)
    }

    override fun verifyLogin() {
        view.showProgressBar()
        if (interactor.isLogged()) view.navigateToMainActivity()
        else view.navigateToLoginActivity()
    }


}