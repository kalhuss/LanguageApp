package uk.ac.aber.dcs.cs31620.languageapp.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WordPairDao_Impl implements WordPairDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WordPair> __insertionAdapterOfWordPair;

  private final EntityDeletionOrUpdateAdapter<WordPair> __deletionAdapterOfWordPair;

  private final EntityDeletionOrUpdateAdapter<WordPair> __updateAdapterOfWordPair;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllWordPairs;

  public WordPairDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWordPair = new EntityInsertionAdapter<WordPair>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `words_table` (`id`,`nativeLanguage`,`nativeWord`,`foreignLanguage`,`foreignWord`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WordPair value) {
        stmt.bindLong(1, value.getId());
        if (value.getNativeLanguage() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNativeLanguage());
        }
        if (value.getNativeWord() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNativeWord());
        }
        if (value.getForeignLanguage() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getForeignLanguage());
        }
        if (value.getForeignWord() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getForeignWord());
        }
      }
    };
    this.__deletionAdapterOfWordPair = new EntityDeletionOrUpdateAdapter<WordPair>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `words_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WordPair value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfWordPair = new EntityDeletionOrUpdateAdapter<WordPair>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `words_table` SET `id` = ?,`nativeLanguage` = ?,`nativeWord` = ?,`foreignLanguage` = ?,`foreignWord` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WordPair value) {
        stmt.bindLong(1, value.getId());
        if (value.getNativeLanguage() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNativeLanguage());
        }
        if (value.getNativeWord() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNativeWord());
        }
        if (value.getForeignLanguage() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getForeignLanguage());
        }
        if (value.getForeignWord() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getForeignWord());
        }
        stmt.bindLong(6, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAllWordPairs = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM words_table";
        return _query;
      }
    };
  }

  @Override
  public Object insertWordPair(final WordPair wordPair,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWordPair.insert(wordPair);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteWordPair(final WordPair wordPair,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfWordPair.handle(wordPair);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateWordPair(final WordPair wordPair,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfWordPair.handle(wordPair);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAllWordPairs(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllWordPairs.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllWordPairs.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<WordPair>> getAllWordPairs() {
    final String _sql = "SELECT * FROM words_table ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"words_table"}, false, new Callable<List<WordPair>>() {
      @Override
      public List<WordPair> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNativeLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "nativeLanguage");
          final int _cursorIndexOfNativeWord = CursorUtil.getColumnIndexOrThrow(_cursor, "nativeWord");
          final int _cursorIndexOfForeignLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "foreignLanguage");
          final int _cursorIndexOfForeignWord = CursorUtil.getColumnIndexOrThrow(_cursor, "foreignWord");
          final List<WordPair> _result = new ArrayList<WordPair>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WordPair _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNativeLanguage;
            if (_cursor.isNull(_cursorIndexOfNativeLanguage)) {
              _tmpNativeLanguage = null;
            } else {
              _tmpNativeLanguage = _cursor.getString(_cursorIndexOfNativeLanguage);
            }
            final String _tmpNativeWord;
            if (_cursor.isNull(_cursorIndexOfNativeWord)) {
              _tmpNativeWord = null;
            } else {
              _tmpNativeWord = _cursor.getString(_cursorIndexOfNativeWord);
            }
            final String _tmpForeignLanguage;
            if (_cursor.isNull(_cursorIndexOfForeignLanguage)) {
              _tmpForeignLanguage = null;
            } else {
              _tmpForeignLanguage = _cursor.getString(_cursorIndexOfForeignLanguage);
            }
            final String _tmpForeignWord;
            if (_cursor.isNull(_cursorIndexOfForeignWord)) {
              _tmpForeignWord = null;
            } else {
              _tmpForeignWord = _cursor.getString(_cursorIndexOfForeignWord);
            }
            _item = new WordPair(_tmpId,_tmpNativeLanguage,_tmpNativeWord,_tmpForeignLanguage,_tmpForeignWord);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public WordPair getFirstWordPair() {
    final String _sql = "SELECT * FROM words_table LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNativeLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "nativeLanguage");
      final int _cursorIndexOfNativeWord = CursorUtil.getColumnIndexOrThrow(_cursor, "nativeWord");
      final int _cursorIndexOfForeignLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "foreignLanguage");
      final int _cursorIndexOfForeignWord = CursorUtil.getColumnIndexOrThrow(_cursor, "foreignWord");
      final WordPair _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNativeLanguage;
        if (_cursor.isNull(_cursorIndexOfNativeLanguage)) {
          _tmpNativeLanguage = null;
        } else {
          _tmpNativeLanguage = _cursor.getString(_cursorIndexOfNativeLanguage);
        }
        final String _tmpNativeWord;
        if (_cursor.isNull(_cursorIndexOfNativeWord)) {
          _tmpNativeWord = null;
        } else {
          _tmpNativeWord = _cursor.getString(_cursorIndexOfNativeWord);
        }
        final String _tmpForeignLanguage;
        if (_cursor.isNull(_cursorIndexOfForeignLanguage)) {
          _tmpForeignLanguage = null;
        } else {
          _tmpForeignLanguage = _cursor.getString(_cursorIndexOfForeignLanguage);
        }
        final String _tmpForeignWord;
        if (_cursor.isNull(_cursorIndexOfForeignWord)) {
          _tmpForeignWord = null;
        } else {
          _tmpForeignWord = _cursor.getString(_cursorIndexOfForeignWord);
        }
        _result = new WordPair(_tmpId,_tmpNativeLanguage,_tmpNativeWord,_tmpForeignLanguage,_tmpForeignWord);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
