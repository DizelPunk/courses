import data.boundairds.IAuthService
import data.boundairds.IEmployeesService
import data.entity.SignInResponse
import data.repository.AuthRepository
import data.repository.ImpEmployeesRepository
import data.services.StubAuthServices
import data.services.StubEmployeesService
import domain.boundaries.IAuthRepository
import domain.boundaries.IEmployeesRepository
import domain.entity.SignInResult
import domain.usecases.EmployeesUseCase
import domain.usecases.LoginUseCase
import org.koin.dsl.module
import presentation.LoginViewModel
import presentation.Router
import presentation.ToastManager

val appModule = module {
    single { SignInResult(get()) }
    single{SignInResponse(get())}
    single<IAuthService>{StubAuthServices()}
    single<IAuthRepository>{AuthRepository(get())}
    single{LoginUseCase(get())}
    single{ Router() }
    single{LoginViewModel(get(),get(),get())}
    single{ToastManager(get())}
}

val employeesModel = module {
    single<IEmployeesService>{StubEmployeesService()}
    single<IEmployeesRepository>{ImpEmployeesRepository(get())}
    single{EmployeesUseCase(get())}
}