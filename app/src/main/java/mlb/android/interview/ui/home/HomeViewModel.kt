package mlb.android.interview.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private var randomBusinessLogicJob: Job? = null

    private var _rotationCounter = MutableLiveData<Int>().apply {
        value = 0
    }

    private var _randomBusinessLogicText = MutableLiveData<String>().apply {
        value = ""
    }

    private val _mlbLiveData = MediatorLiveData<Pair<String, String>>().apply {
        //Combine both the random string and rotation counter live data and update the UI when
        //There's a change in any of them.

    }

    val mlbLiveData: LiveData<Pair<String, String>> = _mlbLiveData

    fun startRandomLogic() {
        //Be careful with re-launching a coroutine if one is already running.
        randomBusinessLogicJob = viewModelScope.launch {
            while (isActive) {
                val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
                val randomString = (1..5)
                    .map { allowedChars.random() }
                    .joinToString("")
                _randomBusinessLogicText.postValue(randomString)
                delay(5000)
            }
        }
    }

    fun increaseRotationCounter() {
        _rotationCounter.postValue(_rotationCounter.value?.plus(1))
    }
}
