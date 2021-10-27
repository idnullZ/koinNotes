package idnull.z.koinnotes.data


import idnull.z.koinnotes.data.room.AppRoomDatabase
import idnull.z.koinnotes.data.room.AppRoomRepository
import idnull.z.koinnotes.presentation.add_new_note.AddNewNoteViewModel
import idnull.z.koinnotes.presentation.main.MainFragmentViewModel
import idnull.z.koinnotes.presentation.note.NoteFragmentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainFragmentViewModel(get()) }
    viewModel { AddNewNoteViewModel(get()) }
    viewModel { NoteFragmentViewModel(get()) }
}

val repositoryModule = module {
    single { AppRoomRepository(get()) }
}

val daoModule = module {
    single { AppRoomDatabase.getInstance(androidContext()).getAppRoomDao }
}
