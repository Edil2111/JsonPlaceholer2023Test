package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.data.repository.PostsRepositoryImpl
import kz.tutorial.jsonplaceholdertypicode.domain.repository.PostsRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<PostsRepository> { PostsRepositoryImpl(get()) }
}