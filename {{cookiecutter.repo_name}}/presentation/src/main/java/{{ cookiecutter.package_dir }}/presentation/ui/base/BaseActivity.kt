package {{ cookiecutter.package_name }}.presentation.ui.base

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import dk.nodes.nstack.kotlin.inflater.NStackBaseContext
import {{ cookiecutter.package_name }}.presentation.extensions.getViewModel
import {{ cookiecutter.package_name }}.presentation.extensions.lifecycleAwareLazy
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(NStackBaseContext(newBase))
    }

    protected inline fun <reified VM : ViewModel> getViewModel(): VM =
        getViewModel(viewModelFactory)

    protected inline fun <reified VM : ViewModel> viewModel(): Lazy<VM> {
        return lifecycleAwareLazy(this) { getViewModel<VM>(viewModelFactory) }
    }
}