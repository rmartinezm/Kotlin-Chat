package mx.com.codewithrob.chat.model.interactor

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import mx.com.codewithrob.chat.interfaces.Main
import mx.com.codewithrob.chat.model.clases.User

class MainInteractorImpl(private val presenter: Main.Presenter) : Main.Interactor {

    private val currentUser = FirebaseAuth.getInstance().currentUser
    private val usersDatabaseRef = FirebaseDatabase.
            getInstance().reference.child("users")

    override fun loadCurrentUser(callback: Main.UserLoadedCallback) {
        usersDatabaseRef.child(currentUser?.uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                val user = User()
                user.id = dataSnapshot?.child("id")?.value.toString()
                user.username = dataSnapshot?.child("username")?.value.toString()
                user.photoURL = dataSnapshot?.child("photoURL")?.value.toString()
                callback.onComplete(user)
            }
            override fun onCancelled(err: DatabaseError?) {
                callback.onComplete(null)
            }
        })
    }

}