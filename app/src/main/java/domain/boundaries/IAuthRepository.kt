package domain.boundaries

import domain.usecases.SignInResult

interface IAuthRepository {
    suspend fun signIn(login:String, password:String): SignInResult
}