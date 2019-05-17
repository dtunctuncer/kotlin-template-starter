package {{ cookiecutter.package_name }}.injection.modules

import dagger.Binds
import dagger.Module
import dk.nodes.arch.domain.injection.scopes.AppScope
import {{ cookiecutter.package_name }}.domain.managers.PrefManager
import {{ cookiecutter.package_name }}.storage.PrefManagerImpl

@Module
abstract class StorageBindingModule {
    @Binds
    @AppScope
    abstract fun bindPrefManager(manager: PrefManagerImpl): PrefManager
}