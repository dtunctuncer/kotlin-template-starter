package {{ cookiecutter.package_name }}.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import {{ cookiecutter.package_name }}.domain.interactors.Fail
import {{ cookiecutter.package_name }}.domain.interactors.InteractorResult
import {{ cookiecutter.package_name }}.domain.interactors.Loading
import {{ cookiecutter.package_name }}.domain.interactors.PostsInteractor
import {{ cookiecutter.package_name }}.domain.interactors.Success
import {{ cookiecutter.package_name }}.domain.interactors.Uninitialized
import {{ cookiecutter.package_name }}.models.Post
import {{ cookiecutter.package_name }}.presentation.extensions.asChannel
import {{ cookiecutter.package_name }}.presentation.extensions.asFlow
import {{ cookiecutter.package_name }}.presentation.extensions.asLiveData
import {{ cookiecutter.package_name }}.presentation.extensions.asResult
import {{ cookiecutter.package_name }}.presentation.extensions.asRx
import {{ cookiecutter.package_name }}.presentation.extensions.runInteractor
import {{ cookiecutter.package_name }}.presentation.nstack.Translation
import {{ cookiecutter.package_name }}.presentation.ui.base.BaseViewModel
import {{ cookiecutter.package_name }}.presentation.ui.base.scope
import {{ cookiecutter.package_name }}.presentation.util.SingleEvent
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    postsInteractor: PostsInteractor
) : BaseViewModel() {

    private val liveDataInteractor = postsInteractor.asLiveData()
    private val resultInteractor = postsInteractor.asResult()
    private val channelInteractor = postsInteractor.asChannel()
    private val rxInteractor = postsInteractor.asRx()
    private val flowInteractor = postsInteractor.asFlow()
    private val _viewState = MediatorLiveData<MainActivityViewState>()
    val viewState: LiveData<MainActivityViewState> = _viewState

    init {
        /** Uncomment below to test LiveDataInteractor */
//        _viewState.addSource(
//            Transformations.map(this.liveDataInteractor.liveData, ::mapResult),
//            _viewState::postValue
//        )
//
        /** Uncomment below to test ChannelInteractor */
//        scope.launch {
//            channelInteractor.receive()
//                .map(Dispatchers.IO) { mapResult(it) }
//                .consumeEach(_viewState::postValue)
//        }
//
        /** Uncomment below to test RxInteractor */
//        disposables += rxInteractor.observe()
//            .subscribeOn(Schedulers.io())
//            .observeOn(Schedulers.io())
//            .map(this::mapResult)
//            .onErrorReturn { mapResult(Fail(it)) }
//            .subscribe(_viewState::postValue, Timber::e)
    }

    fun fetchPosts() {
        /** Uncomment below to test RxInteractor */
//        scope.launchInteractor(rxInteractor)
        /** Uncomment below to test ChannelInteractor */
//        scope.launchInteractor(channelInteractor)
        /** Uncomment below to test LiveDataInteractor */
//        scope.launchInteractor(liveDataInteractor)

        /** Uncomment below to test ResultInteractor */
        scope.launch {
            _viewState.postValue(mapResult(Loading()))
            _viewState.postValue(mapResult(runInteractor(resultInteractor)))
        }

        /** Uncomment below to test FlowInteractor */
//        scope.launch(Dispatchers.IO) {
//            runInteractor(flowInteractor)
//                .map { mapResult(it) }
//                .collect { state ->
//                    _viewState.postValue(state)
//                }
//        }
    }

    private fun mapResult(result: InteractorResult<List<Post>>): MainActivityViewState {
        return when (result) {
            is Success -> _viewState.value?.copy(posts = result.data, isLoading = false)
                ?: MainActivityViewState(posts = result.data)
            is Loading -> viewState.value?.copy(isLoading = true)
                ?: MainActivityViewState(isLoading = true)
            is Fail -> viewState.value?.copy(
                errorMessage = SingleEvent(Translation.error.unknownError),
                isLoading = false
            ) ?: MainActivityViewState(errorMessage = SingleEvent(Translation.error.unknownError))
            is Uninitialized -> MainActivityViewState()
        }
    }
}