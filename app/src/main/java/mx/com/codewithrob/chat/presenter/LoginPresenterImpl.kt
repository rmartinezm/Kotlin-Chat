package mx.com.codewithrob.chat.presenter

import android.content.Intent
import android.util.Log
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FacebookAuthProvider
import mx.com.codewithrob.chat.interfaces.Login
import mx.com.codewithrob.chat.model.enums.Message
import mx.com.codewithrob.chat.model.interactor.LoginInteractorImpl

class LoginPresenterImpl(private val view: Login.View) :
        Login.Presenter, FacebookCallback<LoginResult> {

    private val TAG: String = "LOGIN: "

    private val interactor: Login.Interactor
    private val callbackManager: CallbackManager

    init {
        this.interactor = LoginInteractorImpl(this)
        this.callbackManager = CallbackManager.Factory.create()
    }

    override fun initialiceFacebookButton(loginFacebookButton: LoginButton) {
        loginFacebookButton.registerCallback(callbackManager, this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    override fun loginSuccess() {
        view.navigateToMainActivity()
    }

    override fun loginError(err: String?) {
        view.hideProgressBar()
        Log.e(TAG, err)
        view.showMessage(Message.LOGIN_ERROR, true)
    }

    override fun onSuccess(result: LoginResult) {
        view.showProgressBar()
        val credential: AuthCredential = FacebookAuthProvider.getCredential(result.accessToken.token)
        interactor.loginToFirebase(view.getActivity(), credential)
    }

    override fun onError(error: FacebookException?) {
        view.hideProgressBar()
        view.showMessage(Message.LOGIN_ERROR, true)
    }

    override fun onCancel() {
        view.hideProgressBar()
        view.showMessage(Message.LOGIN_CANCEL)
    }
}