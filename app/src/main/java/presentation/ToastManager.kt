package presentation

import android.content.Context
import android.widget.Toast

class ToastManager(private val context: Context) {
    private val toast:Toast = Toast(context)

    fun showToast(message:String,duration:Int){
        toast.setText(message)
        toast.duration = duration
        toast.show()
    }
}