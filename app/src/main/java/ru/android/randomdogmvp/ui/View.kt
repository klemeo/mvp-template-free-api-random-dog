package ru.android.randomdogmvp.ui

interface View {

    fun refreshDog(dog: DogPresModel)

    fun showDog(value: Boolean)

}