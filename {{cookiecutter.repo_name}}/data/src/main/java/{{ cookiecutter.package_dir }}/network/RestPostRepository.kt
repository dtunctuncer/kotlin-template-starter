package {{ cookiecutter.package_name }}.network

import {{ cookiecutter.package_name }}.models.Post
import {{ cookiecutter.package_name }}.repositories.PostRepository
import {{ cookiecutter.package_name }}.repositories.RepositoryException
import javax.inject.Inject

class RestPostRepository @Inject constructor(private val api: Api) : PostRepository {
    @Throws(RepositoryException::class)
    override suspend fun getPosts(cached: Boolean): List<Post> {
        val response = api.getPosts().execute()
        if (response.isSuccessful) {
            return response.body()
                ?: throw(RepositoryException(
                    response.code(),
                    response.message()
                ))
        }
        throw(RepositoryException(response.code(), response.message()))
    }
}