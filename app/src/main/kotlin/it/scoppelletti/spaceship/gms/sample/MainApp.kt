package it.scoppelletti.spaceship.gms.sample

import android.app.Application
import it.scoppelletti.spaceship.gms.inject.GmsComponent
import it.scoppelletti.spaceship.gms.inject.GmsComponentProvider
import it.scoppelletti.spaceship.gms.sample.inject.DaggerSampleComponent
import it.scoppelletti.spaceship.gms.sample.inject.SampleComponent
import it.scoppelletti.spaceship.inject.AppComponent
import it.scoppelletti.spaceship.inject.StdlibComponent

@Suppress("unused")
class MainApp : Application(), GmsComponentProvider {

    private lateinit var _sampleComponent: SampleComponent

    override fun onCreate() {
        super.onCreate()

        _sampleComponent = DaggerSampleComponent.factory()
                .create(this)
    }

    override fun appComponent(): AppComponent = _sampleComponent

    override fun gmsComponent(): GmsComponent = _sampleComponent

    override fun stdlibComponent(): StdlibComponent = _sampleComponent
}
