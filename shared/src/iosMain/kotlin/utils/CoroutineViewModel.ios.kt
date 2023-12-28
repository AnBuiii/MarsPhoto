package utils

import kotlinx.coroutines.*

actual abstract class CoroutineViewModel {

    actual val coroutineScope = CoroutineScope(Dispatchers.Main + SupervisorJob())
 
   actual fun dispose() {
       coroutineScope.coroutineContext.cancel()
       onCleared()
   }

     protected actual open fun onCleared() {
   }
}