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
public final class WordLanguageDao_Impl implements WordLanguageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Language> __insertionAdapterOfLanguage;

  private final EntityInsertionAdapter<Word> __insertionAdapterOfWord;

  private final EntityDeletionOrUpdateAdapter<Language> __deletionAdapterOfLanguage;

  private final EntityDeletionOrUpdateAdapter<Word> __deletionAdapterOfWord;

  private final EntityDeletionOrUpdateAdapter<Language> __updateAdapterOfLanguage;

  private final EntityDeletionOrUpdateAdapter<Word> __updateAdapterOfWord;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllLanguages;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllWords;

  public WordLanguageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLanguage = new EntityInsertionAdapter<Language>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `languages` (`id`,`nativeLanguage`,`foreignLanguage`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Language value) {
        stmt.bindLong(1, value.getId());
        if (value.getNativeLanguage() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNativeLanguage());
        }
        if (value.getForeignLanguage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getForeignLanguage());
        }
      }
    };
    this.__insertionAdapterOfWord = new EntityInsertionAdapter<Word>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `words` (`id`,`nativeWord`,`foreignWord`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Word value) {
        stmt.bindLong(1, value.getId());
        if (value.getNativeWord() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNativeWord());
        }
        if (value.getForeignWord() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getForeignWord());
        }
      }
    };
    this.__deletionAdapterOfLanguage = new EntityDeletionOrUpdateAdapter<Language>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `languages` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Language value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__deletionAdapterOfWord = new EntityDeletionOrUpdateAdapter<Word>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `words` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Word value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfLanguage = new EntityDeletionOrUpdateAdapter<Language>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `languages` SET `id` = ?,`nativeLanguage` = ?,`foreignLanguage` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Language value) {
        stmt.bindLong(1, value.getId());
        if (value.getNativeLanguage() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNativeLanguage());
        }
        if (value.getForeignLanguage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getForeignLanguage());
        }
        stmt.bindLong(4, value.getId());
      }
    };
    this.__updateAdapterOfWord = new EntityDeletionOrUpdateAdapter<Word>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `words` SET `id` = ?,`nativeWord` = ?,`foreignWord` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Word value) {
        stmt.bindLong(1, value.getId());
        if (value.getNativeWord() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNativeWord());
        }
        if (value.getForeignWord() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getForeignWord());
        }
        stmt.bindLong(4, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAllLanguages = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM languages";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllWords = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM words";
        return _query;
      }
    };
  }

  @Override
  public Object insertLanguage(final Language language,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLanguage.insert(language);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insertWord(final Word word, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWord.insert(word);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteLanguage(final Language language,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfLanguage.handle(language);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteWord(final Word word, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfWord.handle(word);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateLanguage(final Language language,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfLanguage.handle(language);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateWord(final Word word, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfWord.handle(word);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAllLanguages(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllLanguages.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllLanguages.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAllWords(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllWords.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllWords.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<Language>> getAllLanguages() {
    final String _sql = "SELECT * FROM languages";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"languages"}, false, new Callable<List<Language>>() {
      @Override
      public List<Language> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNativeLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "nativeLanguage");
          final int _cursorIndexOfForeignLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "foreignLanguage");
          final List<Language> _result = new ArrayList<Language>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Language _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNativeLanguage;
            if (_cursor.isNull(_cursorIndexOfNativeLanguage)) {
              _tmpNativeLanguage = null;
            } else {
              _tmpNativeLanguage = _cursor.getString(_cursorIndexOfNativeLanguage);
            }
            final String _tmpForeignLanguage;
            if (_cursor.isNull(_cursorIndexOfForeignLanguage)) {
              _tmpForeignLanguage = null;
            } else {
              _tmpForeignLanguage = _cursor.getString(_cursorIndexOfForeignLanguage);
            }
            _item = new Language(_tmpId,_tmpNativeLanguage,_tmpForeignLanguage);
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
  public LiveData<Language> getLanguageById(final int id) {
    final String _sql = "SELECT * FROM languages WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[]{"languages"}, false, new Callable<Language>() {
      @Override
      public Language call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNativeLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "nativeLanguage");
          final int _cursorIndexOfForeignLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "foreignLanguage");
          final Language _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNativeLanguage;
            if (_cursor.isNull(_cursorIndexOfNativeLanguage)) {
              _tmpNativeLanguage = null;
            } else {
              _tmpNativeLanguage = _cursor.getString(_cursorIndexOfNativeLanguage);
            }
            final String _tmpForeignLanguage;
            if (_cursor.isNull(_cursorIndexOfForeignLanguage)) {
              _tmpForeignLanguage = null;
            } else {
              _tmpForeignLanguage = _cursor.getString(_cursorIndexOfForeignLanguage);
            }
            _result = new Language(_tmpId,_tmpNativeLanguage,_tmpForeignLanguage);
          } else {
            _result = null;
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
  public LiveData<List<Word>> getAllWords() {
    final String _sql = "SELECT * FROM words";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"words"}, false, new Callable<List<Word>>() {
      @Override
      public List<Word> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNativeWord = CursorUtil.getColumnIndexOrThrow(_cursor, "nativeWord");
          final int _cursorIndexOfForeignWord = CursorUtil.getColumnIndexOrThrow(_cursor, "foreignWord");
          final List<Word> _result = new ArrayList<Word>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Word _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNativeWord;
            if (_cursor.isNull(_cursorIndexOfNativeWord)) {
              _tmpNativeWord = null;
            } else {
              _tmpNativeWord = _cursor.getString(_cursorIndexOfNativeWord);
            }
            final String _tmpForeignWord;
            if (_cursor.isNull(_cursorIndexOfForeignWord)) {
              _tmpForeignWord = null;
            } else {
              _tmpForeignWord = _cursor.getString(_cursorIndexOfForeignWord);
            }
            _item = new Word(_tmpId,_tmpNativeWord,_tmpForeignWord);
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
  public LiveData<Word> getWordById(final int id) {
    final String _sql = "SELECT * FROM words WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[]{"words"}, false, new Callable<Word>() {
      @Override
      public Word call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNativeWord = CursorUtil.getColumnIndexOrThrow(_cursor, "nativeWord");
          final int _cursorIndexOfForeignWord = CursorUtil.getColumnIndexOrThrow(_cursor, "foreignWord");
          final Word _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNativeWord;
            if (_cursor.isNull(_cursorIndexOfNativeWord)) {
              _tmpNativeWord = null;
            } else {
              _tmpNativeWord = _cursor.getString(_cursorIndexOfNativeWord);
            }
            final String _tmpForeignWord;
            if (_cursor.isNull(_cursorIndexOfForeignWord)) {
              _tmpForeignWord = null;
            } else {
              _tmpForeignWord = _cursor.getString(_cursorIndexOfForeignWord);
            }
            _result = new Word(_tmpId,_tmpNativeWord,_tmpForeignWord);
          } else {
            _result = null;
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
  public LiveData<Word> getFirstWord() {
    final String _sql = "SELECT * FROM words LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"words"}, false, new Callable<Word>() {
      @Override
      public Word call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNativeWord = CursorUtil.getColumnIndexOrThrow(_cursor, "nativeWord");
          final int _cursorIndexOfForeignWord = CursorUtil.getColumnIndexOrThrow(_cursor, "foreignWord");
          final Word _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNativeWord;
            if (_cursor.isNull(_cursorIndexOfNativeWord)) {
              _tmpNativeWord = null;
            } else {
              _tmpNativeWord = _cursor.getString(_cursorIndexOfNativeWord);
            }
            final String _tmpForeignWord;
            if (_cursor.isNull(_cursorIndexOfForeignWord)) {
              _tmpForeignWord = null;
            } else {
              _tmpForeignWord = _cursor.getString(_cursorIndexOfForeignWord);
            }
            _result = new Word(_tmpId,_tmpNativeWord,_tmpForeignWord);
          } else {
            _result = null;
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
