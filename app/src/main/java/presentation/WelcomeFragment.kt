package presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginapplication.MainActivity
import com.example.loginapplication.R
import kotlinx.android.synthetic.main.fragment_welcome.*


class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onStart() {
        super.onStart()
        exit_btn.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.navigateToLoginFragment)
        }
    }
}