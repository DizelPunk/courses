package data.repository

import data.boundairds.IAuthService
import domain.boundaries.IAuthRepository
import domain.entity.SignInResult

class AuthRepository(private val autService: IAuthService) :IAuthRepository {
    override suspend fun signIn(login: String, password: String): SignInResult {
        val response = autService.signIn(login,password)
        return SignInResult(response.statusResponse)
    }
}