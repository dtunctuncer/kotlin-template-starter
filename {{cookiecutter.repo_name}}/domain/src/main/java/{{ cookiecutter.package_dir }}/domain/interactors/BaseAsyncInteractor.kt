package {{ cookiecutter.package_name }}.domain.interactors

interface BaseAsyncInteractor<O> {
    suspend operator fun invoke(): O
}