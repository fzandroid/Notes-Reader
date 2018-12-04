package com.example.faizanwar.roomwordsample.Data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
/**
 * Created by faizanwar on 12/08/18.
 */
@Entity(tableName = "word_table")
public class Word {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;
    public  Word(String word) {
        this.mWord = word;
    }

    public String getWord() {
        return this.mWord;
    }
}
