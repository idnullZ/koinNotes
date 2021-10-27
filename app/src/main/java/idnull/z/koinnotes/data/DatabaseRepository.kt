package idnull.z.koinnotes.data

import androidx.lifecycle.LiveData
import idnull.z.koinnotes.domain.AppNote


interface DatabaseRepository {
    val allNotes:LiveData<List<AppNote>>
    suspend fun insert(note: AppNote,onSuccess:()->Unit)
    suspend fun delete(note: AppNote,onSuccess:()->Unit)
    suspend fun edit(note: AppNote,onSuccess: () -> Unit)

}