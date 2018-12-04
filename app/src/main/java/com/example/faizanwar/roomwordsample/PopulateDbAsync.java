package com.example.faizanwar.roomwordsample;

import android.os.AsyncTask;

import com.example.faizanwar.roomwordsample.DAO.WordDao;
import com.example.faizanwar.roomwordsample.Data.Word;
import com.example.faizanwar.roomwordsample.Database.WordRoomDatabase;

/**
 * Created by faizanwar on 12/08/18.
 */
public class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final WordDao mDao;

    public PopulateDbAsync(WordRoomDatabase db) {
        mDao = db.wordDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        mDao.deleteAll();
        Word word = new Word("Hello");
        mDao.insert(word);
        word = new Word("World");
        mDao.insert(word);
        return null;
    }
}
