package mx.com.codewithrob.chat.interfaces

interface  SplashScreen {

    interface View {
        fun showProgressBar()
        fun hideProgressBar()
        fun showMessage(message: Int)
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