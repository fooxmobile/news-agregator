package ru.fooxer.newsadapter.domain.usecase

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface UseCase<R> {
    fun execute(): Observable<R>
}