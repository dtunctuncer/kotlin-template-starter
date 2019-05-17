package {{ cookiecutter.package_name }}.repositories

import {{ cookiecutter.package_name }}.models.Post

interface PostRepository {
    suspend fun getPosts(cached: Boolean = false): List<Post>
}