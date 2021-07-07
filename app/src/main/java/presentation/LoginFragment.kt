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


class LoginFragment : Fragment(){

    private var viewBuilding: FragmentLoginBinding? = null;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding  = FragmentLoginBinding.inflate(inflater,container,false)
        viewBuilding = binding
        binding.loginBtn.setOnClickListener{
           checkingCorrectData(binding)
        }
        return binding.root
    }

    fun checkingCorrectData(binding:FragmentLoginBinding)
    {
        if (binding.loginTxt.text.toString() == "admin" && binding.passwordTxt.text.toString() == "admin")
            (activity as MainActivity).navController.navigate(R.id.navigateToWelcomeFragment)
        else
            Toast.makeText(activity,"Invalid data", Toast.LENGTH_SHORT).show();
    }

    override fun onDestroyView() {
        viewBuilding =null
        super.onDestroyView()
    }

}