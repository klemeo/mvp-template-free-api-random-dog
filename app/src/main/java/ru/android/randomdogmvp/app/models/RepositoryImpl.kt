package ru.android.randomdogmvp.app.models

import io.reactivex.Single
import ru.android.randomdogmvp.api.DogApi

class RepositoryImpl(
    private val dogApi: DogApi
) : Repository {

    override fun getDog(): Single<Dog> =
        dogApi.getDog().flatMap { response ->
            if ( response.status != null) {
                Single.just(response)
            } else {
                Single.error(Throwable("Request failed"))
            }
        }

}