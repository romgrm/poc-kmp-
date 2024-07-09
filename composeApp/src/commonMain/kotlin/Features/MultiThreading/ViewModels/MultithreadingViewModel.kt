package Features.MultiThreading.ViewModels

import Features.MultiThreading.Usecases.multithreadingData
import Features.MultiThreading.Usecases.Post
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
@HiltViewModel
class multithreadingViewModel : ViewModel() {
    private val mtDataModel = multithreadingData()
    private val posts: LiveData
    fun refreshPostData() {
//        val post =
    }
}