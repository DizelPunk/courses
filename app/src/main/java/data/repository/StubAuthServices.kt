package data.repository

import data.IAuthService
import kotlinx.coroutines.delay

class StubAuthServices : IAuthService {
    override suspend fun signIn(login: String, password: String): SignInResponse {
        return if ( login == password && login.isNotEmpty() && password.isNotEmpty()) {
            delay(2000)
            SignInResponse(true)
        } else SignInResponse(false)
    }
}