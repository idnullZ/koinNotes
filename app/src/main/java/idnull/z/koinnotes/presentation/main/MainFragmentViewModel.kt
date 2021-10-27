package idnull.z.koinnotes.presentation.main


import androidx.lifecycle.ViewModel
import idnull.z.koinnotes.data.room.AppRoomRepository

class MainFragmentViewModel(val repository: AppRoomRepository): ViewModel() {

    val allNotes = repository.allNotes

}