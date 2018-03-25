package mx.com.codewithrob.chat.interfaces

import mx.com.codewithrob.chat.model.enums.Message

interface BaseView {

    fun showProgressBar()
    fun hideProgressBar()
    fun showMessage(message: Message, err:Boolean = false)

}