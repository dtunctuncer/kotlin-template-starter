package {{ cookiecutter.package_name }}.network

import {{ cookiecutter.package_name }}.models.Photo
import {{ cookiecutter.package_name }}.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("photos")
    fun getPhotos(): Call<List<Photo>>
}
