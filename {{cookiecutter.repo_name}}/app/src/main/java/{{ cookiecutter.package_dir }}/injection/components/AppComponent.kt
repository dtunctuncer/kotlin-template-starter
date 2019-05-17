package {{ cookiecutter.package_name }}.injection.components

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dk.nodes.arch.domain.injection.scopes.AppScope
import {{ cookiecutter.package_name }}.App
import {{ cookiecutter.package_name }}.injection.modules.AppModule
import {{ cookiecutter.package_name }}.injection.modules.ExecutorModule
import {{ cookiecutter.package_name }}.injection.modules.InteractorModule
import {{ cookiecutter.package_name }}.injection.modules.RestModule
import {{ cookiecutter.package_name }}.injection.modules.RestRepositoryBinding
import {{ cookiecutter.package_name }}.injection.modules.StorageBindingModule
import {{ cookiecutter.package_name }}.presentation.injection.ViewModelBuilder

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelBuilder::class,
        AppModule::class,
        ExecutorModule::class,
        InteractorModule::class,
        RestModule::class,
        RestRepositoryBinding::class,
        StorageBindingModule::class
    ]
)
@AppScope
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<App>
}