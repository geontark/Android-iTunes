package com.devtak.watcha.di

import androidx.room.Room
import com.devtak.watcha.const.ITUNES_API
import com.devtak.watcha.core.db.AppDatabase
import com.devtak.watcha.core.network.NetworkHandler
import com.devtak.watcha.core.provideRetrofit
import com.devtak.watcha.data.datasource.local.LocalFavoriteTrackDataSource
import com.devtak.watcha.data.datasource.remote.RemoteTrackDataSource
import com.devtak.watcha.data.datasource.remote.TrackApi
import com.devtak.watcha.data.repositoryimpl.FavoriteTrackRepositoryImpl
import com.devtak.watcha.data.repositoryimpl.TrackRepositoryImpl
import com.devtak.watcha.domain.repository.FavoriteTrackRepository
import com.devtak.watcha.domain.repository.TrackRepository
import com.devtak.watcha.domain.usecase.*
import com.devtak.watcha.presentation.viewmodel.FavoriteTracksVM
import com.devtak.watcha.presentation.viewmodel.SearchTracksVM
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

val viewModelModule: Module = module {
    viewModel {
        SearchTracksVM(
            networkHandler = get(),
            searchTrackUseCase = get(),
            getAllFavoriteTracksUseCase = get(),
            favoriteTrackFocUseCase = get(),
            favoriteTrackNorUseCase = get()
        )
    }

    viewModel {
        FavoriteTracksVM(
            favoriteTrackFocUseCase = get(),
            favoriteTrackNorUseCase = get(),
            getAllFavoriteTracksUseCase = get()
        )
    }
}

val useCaseModule: Module = module {
    factory {
        FavoriteTrackFocUseCase(favoriteTrackRepository = get())
    }

    factory {
        FavoriteTrackNorUseCase(favoriteTrackRepository = get())
    }

    factory {
        GetAllFavoriteTracksUseCase(favoriteTrackRepository = get())
    }

    factory {
        SearchTracksUseCase(trackRepository = get())
    }
}

val repositoryModule: Module = module {
    // usecase에 들어가야되므로 캐스팅 필수!
    single {
        TrackRepositoryImpl(
            remoteTrackDataSource = get()
        ) as TrackRepository
    }

    single {
        FavoriteTrackRepositoryImpl(
            localFavoriteTrackDataSource = get()
        ) as FavoriteTrackRepository
    }

}

val dataSourceModule: Module = module {
    single {
        RemoteTrackDataSource(trackApi = get())
    }

    single {
        LocalFavoriteTrackDataSource(favoriteTrackDao = get())
    }
}

val networkModule: Module = module {
    single {
        OkHttpClient.Builder()
            .readTimeout(4, TimeUnit.SECONDS)
            .build()
    }

    single {
        provideRetrofit(okHttpClient = get(), baseURL = ITUNES_API)
    }

    single { get<Retrofit>().create(TrackApi::class.java) }
}

val databaseModule: Module = module {
    single {
        Room.databaseBuilder(
            androidApplication().applicationContext,
            AppDatabase::class.java,
            "itunes_database"
        ).build()
    }

    single {
        get<AppDatabase>().favoriteTrackDao()
    }
}

val networkHandlerModule: Module = module {
    single {
        NetworkHandler(context = androidContext())
    }
}