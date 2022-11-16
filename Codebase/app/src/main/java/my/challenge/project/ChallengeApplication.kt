package my.challenge.project

import android.app.Application
import timber.log.Timber

class ChallengeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        Timber.i("Application: Initializing")
    }
}