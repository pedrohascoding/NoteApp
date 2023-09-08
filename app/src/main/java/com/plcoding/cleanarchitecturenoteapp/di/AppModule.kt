package com.plcoding.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.plcoding.cleanarchitecturenoteapp.featurenote.data.data_source.NoteDatabase
import com.plcoding.cleanarchitecturenoteapp.featurenote.data.repository.NoteRepositoryImpl
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.usecase.AddNote
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.usecase.DeleteNote
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.usecase.GetNote
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.usecase.GetNotes
import com.plcoding.cleanarchitecturenoteapp.featurenote.domain.usecase.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNoteREpository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases{
        return  NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}