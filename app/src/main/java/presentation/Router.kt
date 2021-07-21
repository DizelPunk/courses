package presentation

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import org.koin.core.component.getScopeId

class Router {

    private val subscribers  = mutableSetOf<(screenId:String, args: Bundle)->Unit>()

    fun subscribeToNavigationEvent(onNavigation:(screenId:String,args: Bundle)->Unit){
        subscribers.add(onNavigation)
    }
    fun navigateTo(screenId: String, args: Bundle = Bundle()){
        for (elem in subscribers)
        {
            elem(screenId,args)
        }
    }
    fun unSubscribe(onNavigation:(screenId:String,args: Bundle)->Unit){
        subscribers.remove(onNavigation)
    }
}