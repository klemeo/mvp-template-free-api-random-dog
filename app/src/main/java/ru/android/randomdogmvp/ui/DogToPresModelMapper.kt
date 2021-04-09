package ru.android.randomdogmvp.ui

import org.koin.core.KoinComponent
import ru.android.randomdogmvp.app.models.Dog

class DogToPresModelMapper : KoinComponent {

    fun map(from: Dog) = DogPresModel(
        message = from.message,
        status = from.status
    )

}