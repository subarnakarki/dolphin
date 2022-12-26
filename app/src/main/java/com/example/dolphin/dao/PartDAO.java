package com.example.dolphin.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dolphin.entities.Part;

import java.util.List;
@Dao
public interface PartDAO {
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insert(Part part);

        @Update
        void update(Part part);

        @Delete
        void delete(Part part);

        @Query("SELECT * FROM parts ORDER BY partID ASC")
        List<Part> getAllParts();

        @Query("SELECT * FROM parts WHERE productID =:productID ORDER BY partID ASC")
        List<Part> getAllAssociatedParts(int productID);
}
