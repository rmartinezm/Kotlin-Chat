package mx.com.codewithrob.chat.interfaces

interface BaseView {

    fun showProgressBar()
    fun hideProgressBar()
    fun showMessage(message: Int)
    fun showMessage(message: String)
    fun showErrorMessage(err: Int)
    fun showErrorMessage(err: String)

}