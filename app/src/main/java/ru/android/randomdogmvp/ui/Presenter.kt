package ru.android.randomdogmvp.ui

import io.reactivex.Single
import org.koin.core.inject
import ru.android.randomdogmvp.app.models.Dog
import ru.android.randomdogmvp.app.models.Repository
import ru.android.randomdogmvp.base.MvpPresenter

class Presenter(view: View) : MvpPresenter<View>(view) {

    private val repository: Repository by inject()

    private val dogToPresModelMapper = DogToPresModelMapper()

    lateinit var getDog: Dog

    override fun onCreate() {
        loadDog()
    }

    fun loadDog() {
        compositeDisposable.add(
            repository.getDog()
                .flatMap { dog ->
                    getDog = dog
                    Single.just(dog)
                }
                .map {
                    dogToPresModelMapper.map(it)
                }
                .compose(composer.single())
                .subscribe({ dog ->
                    view?.refreshDog(dog)
                    view?.showDog(true)
                }, {
                    //.
                })
        )
    }

}