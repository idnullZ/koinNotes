package idnull.z.koinnotes

import android.app.Application
import idnull.z.koinnotes.data.daoModule
import idnull.z.koinnotes.data.repositoryModule
import idnull.z.koinnotes.data.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application(){



    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(viewModelModule)
            modules(repositoryModule)
            modules(daoModule)
        }
    }



}



