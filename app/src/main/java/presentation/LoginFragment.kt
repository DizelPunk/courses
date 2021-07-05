package presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.loginapplication.MainActivity
import com.example.loginapplication.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onStart() {
        super.onStart()
        login_btn.setOnClickListener{
            if (login_txt.text.toString() == "admin" && password_txt.text.toString() == "admin")
                (activity as MainActivity).navController.navigate(R.id.navigateToWelcomeFragment)
            else
                Toast.makeText(activity,"Неверные данные", Toast.LENGTH_SHORT).show();
        }
    }
}