package presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.loginapplication.MainActivity
import com.example.loginapplication.R
import com.example.loginapplication.databinding.FragmentLoginBinding
import domain.entity.SignInResult
import domain.usecases.LoginModelUseCase
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject
import org.koin.core.context.GlobalContext


class LoginFragment : Fragment(){

    private var viewBuilding: FragmentLoginBinding? = null;
    private val loginModel:LoginModelUseCase by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding  = FragmentLoginBinding.inflate(inflater,container,false)
        viewBuilding = binding
        binding.loginBtn.setOnClickListener{
            MainScope().launch {
                disableElementsOfLoginActivity(false)
                val result = loginModel.signIn(
                    viewBuilding!!.loginTxt.text.toString(),
                    viewBuilding!!.passwordTxt.text.toString()
                )
                if (result.statusResult)
                    (activity as MainActivity).navController.navigate(R.id.navigateToWelcomeFragment)
                else {
                    Toast.makeText(activity, "Uncorrected data, try again", Toast.LENGTH_SHORT)
                        .show()
                    disableElementsOfLoginActivity(true)
                }
            }
        }
        return binding.root
    }


    private fun disableElementsOfLoginActivity(mode:Boolean)
    {
        viewBuilding!!.loginBtn.isClickable = mode
        viewBuilding!!.loginTxt.isEnabled = mode
        viewBuilding!!.passwordTxt.isEnabled = mode
    }

    override fun onDestroyView() {
        viewBuilding =null
        super.onDestroyView()
    }

}