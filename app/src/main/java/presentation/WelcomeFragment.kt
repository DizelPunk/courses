package presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        router.subscribeToNavigationEvent(::navigateTo)
    }


    override fun onDestroyView() {
        router.unSubscribe(::navigateTo)
        super.onDestroyView()
    }

    override fun onClick(view: View) {
        Navigation.findNavController(requireView()).popBackStack()
    }


}