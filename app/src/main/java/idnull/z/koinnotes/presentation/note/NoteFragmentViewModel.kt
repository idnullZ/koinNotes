package idnull.z.koinnotes.presentation.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import idnull.z.koinnotes.data.room.AppRoomRepository
import idnull.z.koinnotes.domain.AppNote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteFragmentViewModel( private val repository: AppRoomRepository): ViewModel() {
    fun delete(note: AppNote, onSuccess:()->Unit)=
        viewModelScope.launch(Dispatchers.IO){
            repository.delete(note){
                onSuccess()
            }
        }
}