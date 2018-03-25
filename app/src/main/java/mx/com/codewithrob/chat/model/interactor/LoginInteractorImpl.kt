package mx.com.codewithrob.chat.model.interactor

import android.support.v7.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import mx.com.codewithrob.chat.interfaces.Login
import mx.com.codewithrob.chat.model.clases.User

class LoginInteractorImpl(private val presenter: Login.Presenter) : Login.Interactor {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firebaseDatabaseUsers: DatabaseReference =
            FirebaseDatabase.getInstance().reference.child("users")

    private val valueEventListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot?) {
            if (dataSnapshot!!.exists()) presenter.loginSuccess()
            else {
                val currentUser = firebaseAuth.currentUser!!
                val user = User(currentUser.uid,
                        currentUser.displayName!!, currentUser.photoUrl.toString())
                firebaseDatabaseUsers.child(currentUser.uid).setValue(user).addOnCompleteListener({
                    presenter.loginSuccess()
                })
            }
        }
        override fun onCancelled(databaseError: DatabaseError) {
            presenter.loginError(databaseError.message)
        }
    }

    override fun loginToFirebase(activity: AppCompatActivity, credential: AuthCredential) {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(activity, { task: Task<AuthResult> ->
            if ( task.isSuccessful ) {
                val id : String = firebaseAuth.currentUser!!.uid
                firebaseDatabaseUsers.child(id).addListenerForSingleValueEvent(valueEventListener)
            } else presenter.loginError(task.exception?.message)
        })
    }

}