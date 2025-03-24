package ru.android.randomdogmvp.ui

import ru.android.randomdogmvp.app.models.Dog

fun Dog.toMap() = DogPresModel(
    message = message,
    status = status
)