package mx.com.codewithrob.chat.presenter

import mx.com.codewithrob.chat.interfaces.SplashScreen
import mx.com.codewithrob.chat.model.interactor.SplashScreenInteractorImpl

class SplashScreenPresenterImpl: SplashScreen.Presenter {

    private val view : SplashScreen.View
    private val interactor : SplashScreen.Interactor


    constructor(view: SplashScreen.View){
        this.view = view
        interactor = SplashScreenInteractorImpl(this)
    }

    override fun verifyLogin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}