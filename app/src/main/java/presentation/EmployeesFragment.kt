package presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.loginapplication.R
import domain.usecases.EmployeesModelUseCase
import domain.usecases.LoginModelUseCase
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class EmployeesFragment : Fragment() {

    val employeesModelUseCase:EmployeesModelUseCase by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_empolyes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MainScope().launch {
            val listOfEmployees = employeesModelUseCase.getEmployees()
            listOfEmployees.forEach {
                Log.i("Name of employee:",it.getFirstName())
            }
        }
    }
}