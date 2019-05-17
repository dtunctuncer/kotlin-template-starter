package {{ cookiecutter.package_name }}.models

data class Post(
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String
)