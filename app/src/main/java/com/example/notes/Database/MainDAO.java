package com.example.notes.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notes.Models.Notes;
import static androidx.room.OnConflictStrategy.REPLACE;

import java.util.List;

@Dao
public interface MainDAO {

    @Insert(onConflict = REPLACE)
    void insert(Notes notes);

    @Query("UPDATE notes SET title = :title, notes = :notes WHERE ID = :id")
    void update(int id, String title, String notes);

    @Delete
    void delete(Notes notes);

    @Query("UPDATE notes SET pinned = :pin WHERE ID = :id")
    void pin (int id,boolean pin);

    @Query("SELECT * FROM notes ORDER BY CASE WHEN pinned = 1 THEN 0 ELSE 1 END, id DESC")
    List<Notes> getAll();
}
