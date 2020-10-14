package ru.fooxer.newsadapter.domain.usecase

import io.reactivex.rxjava3.core.Observable

interface UseCase<R> {
    fun execute(): Observable<R>
}