package data.boundairds

import data.entity.SignInResponse

interface IAuthService {
    suspend fun signIn(login:String,password:String): SignInResponse
}