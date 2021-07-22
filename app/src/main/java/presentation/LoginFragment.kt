package presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.loginapplication.R
import com.example.loginapplication.databinding.FragmentLoginBinding
import org.koin.android.ext.android.inject


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by inject()
    private val router:Router by inject()
    private val toastManager:ToastManager by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.viewModel = loginViewModel
        binding.lifecycleOwner = this
        return binding!!.root
    }

    private fun navigateTo(screenId:String, args:Bundle?){
        Navigation.findNavController(requireView()).navigate(R.id.navigateToWelcomeFragment)
    }

    override fun onResume() {
        super.onResume()
        router.subscribeToNavigationEvent(::navigateTo)
    }

    override fun onPause() {
        super.onPause()
        router.unSubscribe(::navigateTo)
    }

}