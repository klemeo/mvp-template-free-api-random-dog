package ru.android.randomdogmvp.app

import org.koin.dsl.module
import ru.android.randomdogmvp.api.Api
import ru.android.randomdogmvp.api.ApiImpl
import ru.android.randomdogmvp.app.models.Repository
import ru.android.randomdogmvp.app.models.RepositoryImpl
import ru.android.randomdogmvp.base.SchedulerComposerFactory
import ru.android.randomdogmvp.base.ScreensManager
import ru.android.randomdogmvp.base.ScreensManagerImpl

private val allModule = module {

    //appModule
    factory {
        SchedulerComposerFactory.android()
    }

    single<ScreensManager> {
        ScreensManagerImpl()
    }
    //endregion

    //apiModule
    single<Api> {
        ApiImpl()
    }
    //endregion

    //dataModule
    single<Repository> {
        RepositoryImpl(
            dogApi = get<Api>().getApi()
        )
    }
    //endregion

}

val modules = listOf(allModule)