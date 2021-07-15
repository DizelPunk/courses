package data.repository

import data.IAuthService
import domain.boundaries.IAuthRepository
import domain.usecases.SignInResult

class AuthRepository(private val autService:IAuthService) :IAuthRepository {
    override suspend fun signIn(login: String, password: String): SignInResult {
        val response = autService.signIn(login,password)
        return SignInResult(response.statusResponse)
    }
}