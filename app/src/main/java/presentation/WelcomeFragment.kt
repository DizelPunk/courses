package presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginapplication.MainActivity
import com.example.loginapplication.R
import com.example.loginapplication.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private var viewBinding: FragmentWelcomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentWelcomeBinding.inflate(inflater,container,false)
        viewBinding = binding
        binding.exitBtn.setOnClickListener{
            goToLoginFragment()
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    fun goToLoginFragment(){
        (activity as MainActivity).navController.navigate(R.id.navigateToLoginFragment)
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }


}