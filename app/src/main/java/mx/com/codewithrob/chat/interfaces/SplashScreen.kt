package mx.com.codewithrob.chat.interfaces

interface  SplashScreen {

    interface View : BaseView {
        fun navigateToLoginActivity()
        fun navigateToMainActivity()
    }

    interface Presenter {
        fun verifyLogin()
    }

    interface  Interactor {
        fun isLogged() : Boolean
    }

}