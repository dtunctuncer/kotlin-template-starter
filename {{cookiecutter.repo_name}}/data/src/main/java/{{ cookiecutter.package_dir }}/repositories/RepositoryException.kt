package {{ cookiecutter.package_name }}.repositories

class RepositoryException(code: Int, msg: String) : RuntimeException(msg)