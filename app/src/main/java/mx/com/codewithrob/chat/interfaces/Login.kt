package mx.com.codewithrob.chat.interfaces

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.facebook.login.widget.LoginButton
import com.google.firebase.auth.AuthCredential

interface Login {

    interface View  : BaseView {
        fun navigateToMainActivity()
        fun getActivity() : AppCompatActivity
    }

    interface Presenter {
        fun initialiceFacebookButton(loginFacebookButton: LoginButton)
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
        fun loginSuccess()
        fun loginError(err: String?)
    }

    interface Interactor {
        fun loginToFirebase(activity: AppCompatActivity, credential: AuthCredential)
    }

}