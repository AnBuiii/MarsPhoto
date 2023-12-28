package viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import model.MarsPhoto
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import repository.MarsRepository
import utils.CoroutineViewModel

class MarsViewModel : CoroutineViewModel(), KoinComponent  {
    private val marsRepository: MarsRepository by inject()
        private val _marsPhotos = MutableStateFlow<List<MarsPhoto>>(emptyList())
        val marsPhotos = _marsPhotos.asStateFlow()

        init {
            getMars()
        }
    
        fun observeMars(onChange: (List<MarsPhoto>) -> Unit) {
            _marsPhotos.onEach {
                onChange(it)
            }.launchIn(coroutineScope)
        }

        fun getMars() {
            coroutineScope.launch {
                _marsPhotos.value = marsRepository.getMarsPhoto()
            }
        }
}