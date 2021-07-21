package presentation

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginapplication.R
import domain.usecases.LoginModelUseCase
import kotlinx.coroutines.launch

class LoginViewModel(private val router: Router, private val loginModel: LoginModelUseCase) :
    ViewModel() {

    private val _isEnabled = MutableLiveData(true)

    var loginTxt = ""
    var passwordTxt = ""
    var isEnabled: LiveData<Boolean> = _isEnabled

    fun signIn(context: Context) {
        viewModelScope.launch {
            _isEnabled.value = false
            val result = loginModel.signIn(
                loginTxt,
                passwordTxt
            )
            _isEnabled.value = true
            if (result.statusResult) {
                router.navigateTo(R.id.navigateToWelcomeFragment.toString())
            } else {
                Toast.makeText(context, "Uncorrected data, try again", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}