package mx.com.codewithrob.chat.interfaces

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.facebook.login.widget.LoginButton
import com.google.firebase.auth.AuthCredential

interface Login {

    interface View {
        fun showProgressBar()
        fun hideProgressBar()
        fun showErrorMessage(message: Int)
        fun showErrorMessage(message: String)
        fun showMessage(message: String)
        fun showMessage(message: Int)
        fun navigateToMainActivity()
        fun getActivity() : AppCompatActivity
    }

    interface Presenter {
        fun initialiceFacebookButton(loginFacebookButton: LoginButton)
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
        fun loginSuccessfull()
        fun loginError(err: String)
    }

    interface Interactor {
        fun loginToFirebase(activity: AppCompatActivity, credential: AuthCredential)
    }

}