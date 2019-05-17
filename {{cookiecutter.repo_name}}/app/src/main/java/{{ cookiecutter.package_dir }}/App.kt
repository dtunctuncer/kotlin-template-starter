package {{ cookiecutter.package_name }}

import android.content.Context
import androidx.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import {{ cookiecutter.package_name }}.inititializers.AppInitializer
import {{ cookiecutter.package_name }}.injection.components.DaggerAppComponent
import javax.inject.Inject

class App : DaggerApplication() {

    @Inject lateinit var initializer: AppInitializer
    override fun onCreate() {
        super.onCreate()
        initializer.init(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}