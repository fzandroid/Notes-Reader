package com.example.faizanwar.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.faizanwar.roomwordsample.DAO.WordDao;
import com.example.faizanwar.roomwordsample.Data.Word;
import com.example.faizanwar.roomwordsample.Database.WordRoomDatabase;

import java.util.List;

/**
 * Created by faizanwar on 12/08/18.
 */
public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;
    private static final String OPERATION_ADD = "ADD";
    private static final String OPERATION_DELETE = "DELETE";

    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }


    public void insert(Word word) {
        new insertAsyncTask(mWordDao, OPERATION_ADD).execute(word);
    }

    public void delete(Word word) {
        new insertAsyncTask(mWordDao, OPERATION_DELETE).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;
        private String mOperationType;

        insertAsyncTask(WordDao dao, String operationType) {
            mAsyncTaskDao = dao;
            mOperationType = operationType;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            if (mOperationType.equalsIgnoreCase(OPERATION_ADD))
                mAsyncTaskDao.insert(params[0]);
            else
                mAsyncTaskDao.delete(params[0]);
            return null;
        }
    }
}
