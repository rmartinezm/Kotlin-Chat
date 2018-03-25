package mx.com.codewithrob.chat.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import mx.com.codewithrob.chat.R
import mx.com.codewithrob.chat.model.clases.ChatMessage
import mx.com.codewithrob.chat.model.clases.User

class MessageAdapter(
        private val messages: List<ChatMessage>,
        private val context: Context,
        private val currentUser: User
    ): RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        val parentView: LinearLayout = itemView!!.findViewById(R.id.layoutMessage)
        val tvMessage: TextView = itemView!!.findViewById(R.id.tvMessage)

    }

    override fun getItemCount(): Int = messages.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_message, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messages[position]
        holder.tvMessage.text = message.message
        if (message.senderName == currentUser.username){
            holder.parentView.gravity = Gravity.END
            holder.tvMessage.gravity = Gravity.END
            holder.tvMessage.background = context.resources.getDrawable(R.drawable.own_message_background)
        } else {
            holder.parentView.gravity = Gravity.START
            holder.tvMessage.gravity = Gravity.START
            holder.tvMessage.background = context.resources.getDrawable(R.drawable.message_received_background)
        }
    }

}