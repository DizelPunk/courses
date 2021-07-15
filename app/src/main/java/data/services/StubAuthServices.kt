package data.services

import data.boundairds.IAuthService
import data.entity.SignInResponse
import kotlinx.coroutines.delay

class StubAuthServices : IAuthService {
    override suspend fun signIn(login: String, password: String): SignInResponse {
        return if ( login == password && login.isNotEmpty() && password.isNotEmpty()) {
            delay(2000)
            SignInResponse(true)
        } else {
            delay(2000)
            SignInResponse(false)
        }
    }
}