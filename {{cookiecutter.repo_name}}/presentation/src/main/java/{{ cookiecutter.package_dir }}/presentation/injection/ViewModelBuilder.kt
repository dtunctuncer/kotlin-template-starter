package {{ cookiecutter.package_name }}.presentation.injection

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import {{ cookiecutter.package_name }}.presentation.ui.main.MainActivityBuilder

@Module(
    includes = [
        MainActivityBuilder::class
    ]
)
abstract class ViewModelBuilder {

    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}