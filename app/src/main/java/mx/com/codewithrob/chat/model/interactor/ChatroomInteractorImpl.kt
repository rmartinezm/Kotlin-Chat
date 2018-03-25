package mx.com.codewithrob.chat.model.interactor

import com.google.firebase.database.*
import mx.com.codewithrob.chat.interfaces.Chatroom
import mx.com.codewithrob.chat.model.clases.ChatMessage
import mx.com.codewithrob.chat.model.clases.User
import mx.com.codewithrob.chat.model.services.FirebaseDatabaseService
import mx.com.codewithrob.chat.model.services.FirebaseDatabaseService.DataLoadedCallback

class ChatroomInteractorImpl(private val presenter: Chatroom.Presenter): Chatroom.Interactor {

    private lateinit var channelRef: DatabaseReference
    private val CHANNELS: String = "channels"
    private val GLOBAL: String = "global"

    override fun loadCurrentUser() {
        FirebaseDatabaseService.loadCurrentUser(object : DataLoadedCallback<User> {
            override fun onComplete(result: User?) {
                presenter.updateUser(result)
            }
        })
    }

    override fun loadChatMessages(channel: String?, callback: Chatroom.CallbackMessagesListLoaded) {
        channelRef = FirebaseDatabase.getInstance().reference.child(CHANNELS).child(channel ?: GLOBAL)
        channelRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                callback.onSuccess(listOf())
            }
            override fun onCancelled(err: DatabaseError?) {
                callback.onError(err?.message)
            }
        })
    }

    override fun saveMessage(message: ChatMessage, callback: Chatroom.CallbackDataSaved) {
        val key = channelRef.push().key
        channelRef.child(key).setValue(message).addOnCompleteListener { callback.onComplete() }
    }

}