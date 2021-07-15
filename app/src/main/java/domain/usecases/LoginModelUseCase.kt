package domain.usecases

import domain.boundaries.IAuthRepository

class LoginModelUseCase(private val authRepository: IAuthRepository) {
    suspend fun signIn(login:String, password:String): SignInResult
    {
        return SignInResult(authRepository.signIn(login,password).statusResut)
    }
}