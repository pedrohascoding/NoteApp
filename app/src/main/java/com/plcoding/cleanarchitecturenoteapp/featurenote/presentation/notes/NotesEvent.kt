package com.plcoding.cleanarchitecturenoteapp.featurenote.presentation.notes

import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}