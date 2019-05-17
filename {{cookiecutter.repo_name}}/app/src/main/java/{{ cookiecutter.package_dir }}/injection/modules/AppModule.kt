package {{ cookiecutter.package_name }}.injection.modules

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import {{ cookiecutter.package_name }}.App
import {{ cookiecutter.package_name }}.inititializers.AppInitializer
import {{ cookiecutter.package_name }}.inititializers.AppInitializerImpl

@Module
abstract class AppModule {

    @Binds
    abstract fun bindAppInitalizer(initializer: AppInitializerImpl): AppInitializer

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideContext(application: App): Context = application.applicationContext
    }
}