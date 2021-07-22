package presentation

import android.os.Bundle

class Router {

    private val subscribers = mutableSetOf<(screenId: String, args: Bundle) -> Unit>()

    fun subscribeToNavigationEvent(onNavigation: (screenId: String, args: Bundle) -> Unit) {
        subscribers.add(onNavigation)
    }

    fun navigateTo(screenId: String, args: Bundle = Bundle()) {
        subscribers.forEach {
            it.invoke(screenId, args)
        }
    }

    fun unSubscribe(onNavigation: (screenId: String, args: Bundle) -> Unit) {
        subscribers.remove(onNavigation)
    }
}