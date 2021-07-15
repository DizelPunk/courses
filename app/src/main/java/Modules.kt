import data.boundairds.IAuthService
import data.entity.SignInResponse
import data.repository.AuthRepository
import data.services.StubAuthServices
import domain.boundaries.IAuthRepository
import domain.entity.SignInResult
import domain.usecases.LoginModelUseCase
import org.koin.dsl.module

val appModule = module {
    single { SignInResult(get()) }
    single{SignInResponse(get())}
    single<IAuthService>{StubAuthServices()}
    single<IAuthRepository>{AuthRepository(get())}
    single{LoginModelUseCase(get())}

}