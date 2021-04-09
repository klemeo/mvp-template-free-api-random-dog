package ru.android.randomdogmvp.api

import io.reactivex.Single
import retrofit2.http.GET
import ru.android.randomdogmvp.app.models.Dog

interface DogApi {

    @GET("breeds/image/random")
    fun getDog(): Single<Dog>

}