package di

import api.KtorApi
import api.KtorApiImpl
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import repository.MarsRepository
import viewmodel.MarsViewModel

fun initKoin(appDeclaration: KoinAppDeclaration) = startKoin {
    appDeclaration()
    modules(
        apiModule,
        repositoryModule,
        viewModelModule
    )
}

private val apiModule = module {
    single<KtorApi> { KtorApiImpl() }
}

private val repositoryModule = module {
    single { MarsRepository() }
}

private val viewModelModule = module {
    single { MarsViewModel() }
}

fun initKoin() = initKoin {  }

fun c() {
    
}