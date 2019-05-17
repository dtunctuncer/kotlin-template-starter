package {{ cookiecutter.package_name }}.presentation.ui.main

import {{ cookiecutter.package_name }}.models.Post
import {{ cookiecutter.package_name }}.presentation.util.SingleEvent

data class MainActivityViewState(
    val posts: List<Post> = emptyList(),
    val errorMessage: SingleEvent<String>? = null,
    val isLoading: Boolean = false
)