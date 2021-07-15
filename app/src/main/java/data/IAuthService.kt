package data

import data.repository.SignInResponse

interface IAuthService {
    suspend fun signIn(login:String,password:String): SignInResponse
}