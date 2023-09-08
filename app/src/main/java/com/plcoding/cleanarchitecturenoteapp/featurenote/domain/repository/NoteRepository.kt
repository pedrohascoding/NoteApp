package com.plcoding.cleanarchitecturenoteapp.featurenote.domain.repository

import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<Note>>

    suspend fun getNotesById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}