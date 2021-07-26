package presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.loginapplication.R
import com.example.loginapplication.databinding.FragmentWelcomeBinding
import org.koin.android.ext.android.inject


class WelcomeFragment : Fragment(), IUIOnClickListener {

    private val router: Router by inject()
    private lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding.clickListener = this
        // Inflate the layout for this fragment
        return binding.root
    }

    fun navigateTo(screenId: String, args: Bundle?) {
        Navigation.findNavController(requireView()).navigate(screenId.toInt())
    }

    override fun onResume() {
        super.onResume()
        router.subscribeToNavigationEvent(::navigateTo)
    }

    override fun onPause() {
        router.unSubscribe(::navigateTo)
        super.onPause()
    }

    override fun onClick(view: View) {
        when(view.id)
        {
            R.id.exit_btn -> Navigation.findNavController(requireView()).popBackStack()
            R.id.employees_btn -> navigateTo(R.id.action_welcomeFragment_to_employeesFragment.toString(),null)
        }
    }


}