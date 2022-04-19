package br.com.easynotes.database

import br.com.easynotes.model.Note

class Database {
    companion object {
        var notes = mutableListOf<Note>()
    }
}