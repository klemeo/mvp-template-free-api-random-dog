package ru.android.randomdogmvp.app.models

import io.reactivex.Single

interface Repository {

    fun getDog(): Single<Dog>

}