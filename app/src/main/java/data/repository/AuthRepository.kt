package data.repository

import data.IAuthService
import domain.boundaries.IAuthRepository
import domain.usecases.SignInResult

class AuthRepository(private val autService:IAuthService) :IAuthRepository {
    override suspend fun signIn(login: String, password: String): SignInResult {
        return SignInResult(autService.signIn(login,password).statusResponse)
    }
}