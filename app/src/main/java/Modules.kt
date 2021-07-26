import data.boundairds.IAuthService
import data.entity.SignInResponse
import data.repository.AuthRepository
import data.services.StubAuthServices
import domain.boundaries.IAuthRepository
import domain.entity.SignInResult
import domain.usecases.LoginModelUseCase
import org.koin.dsl.module
import presentation.LoginViewModel
import presentation.Router
import presentation.ToastManager

val appModule = module {
    single { SignInResult(get()) }
    single{SignInResponse(get())}
    single<IAuthService>{StubAuthServices()}
    single<IAuthRepository>{AuthRepository(get())}
    single{LoginModelUseCase(get())}
    single{ Router() }
    single{LoginViewModel(get(),get(),get())}
    single{ToastManager(get())}
}