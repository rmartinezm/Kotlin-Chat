package mx.com.codewithrob.chat.model.services

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import mx.com.codewithrob.chat.model.clases.User

object FirebaseDatabaseService {

    private val USERS: String = "users"
    private val databaseReference = FirebaseDatabase.getInstance().reference
    private val usersDatabaseReference = databaseReference.child(USERS)

    fun loadCurrentUser(callback: DataLoadedCallback<User>){
        val uid: String? = FirebaseAuth.getInstance().uid
        if (uid == null) callback.onComplete(null)
        else {
            usersDatabaseReference.child(uid).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(err: DatabaseError?) {
                    callback.onComplete(null)
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    callback.onComplete(User(
                            uid,
                            snapshot.child("username").value.toString(),
                            snapshot.child("photoURL").value.toString()))
                }
            })
        }
    }

    interface DataLoadedCallback<in T> {
        fun onComplete(result: T?)
    }

}