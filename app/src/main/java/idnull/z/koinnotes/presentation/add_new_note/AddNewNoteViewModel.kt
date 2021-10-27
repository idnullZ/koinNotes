package idnull.z.koinnotes.presentation.add_new_note


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import idnull.z.koinnotes.data.room.AppRoomRepository
import idnull.z.koinnotes.domain.AppNote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewNoteViewModel(private val repository: AppRoomRepository) : ViewModel() {
    fun insert(note: AppNote, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(note) {
                onSuccess()
            }
        }
    }

    fun edit(note: AppNote, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.edit(note) {
                onSuccess()
            }
        }
    }
}