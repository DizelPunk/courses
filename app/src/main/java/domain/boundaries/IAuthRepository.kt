package domain.boundaries

import domain.entity.SignInResult

interface IAuthRepository {
    suspend fun signIn(login:String, password:String): SignInResult
}