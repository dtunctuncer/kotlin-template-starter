package {{ cookiecutter.package_name }}.domain.interactors

import {{ cookiecutter.package_name }}.models.Post
import {{ cookiecutter.package_name }}.repositories.PostRepository
import java.io.IOException
import javax.inject.Inject

class PostsInteractor @Inject constructor(
    private val postRepository: PostRepository
) : BaseAsyncInteractor<List<Post>> {

    override suspend fun invoke(): List<Post> {
        val posts = postRepository.getPosts(true)
        if (posts.isEmpty()) {
            throw IOException("Empty posts")
        }
        return posts
    }
}