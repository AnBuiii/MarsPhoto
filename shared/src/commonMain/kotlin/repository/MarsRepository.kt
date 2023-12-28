package repository

import api.KtorApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MarsRepository : KoinComponent{
    private val ktorApi: KtorApi by inject()
    
    suspend fun getMarsPhoto() = ktorApi.getMars()
}

