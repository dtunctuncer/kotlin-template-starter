package {{ cookiecutter.package_name }}.injection.modules

import dagger.Binds
import dagger.Module
import dk.nodes.arch.domain.injection.scopes.AppScope
import {{ cookiecutter.package_name }}.network.RestPostRepository
import {{ cookiecutter.package_name }}.repositories.PostRepository

@Module
abstract class RestRepositoryBinding {
    @Binds
    @AppScope
    abstract fun bindPostRepository(repository: RestPostRepository): PostRepository
}