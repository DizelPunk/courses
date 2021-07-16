package domain.usecases

import domain.boundaries.IAuthRepository
import domain.entity.SignInResult

class LoginModelUseCase(private val authRepository: IAuthRepository) {
    suspend fun signIn(login:String, password:String): SignInResult
    {
        val response = authRepository.signIn(login,password)
        return SignInResult(response.statusResult)
    }
}