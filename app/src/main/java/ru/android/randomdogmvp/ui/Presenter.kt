package ru.android.randomdogmvp.ui

import org.koin.core.component.inject
import ru.android.randomdogmvp.app.models.Repository
import ru.android.randomdogmvp.base.MvpPresenter

class Presenter(view: View) : MvpPresenter<View>(view) {

    private val repository: Repository by inject()

    override fun onCreate() {
        loadDog()
    }

    fun loadDog() {
        compositeDisposable.add(
            repository.getDog()
                .map {
                    it.toMap()
                }
                .compose(composer.single())
                .doFinally { view?.showDog(true) }
                .subscribe { dog ->
                    view?.refreshDog(dog)
                }
        )
    }

}