package uk.ac.aber.dcs.cs31620.languageapp.datasource;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageDao;
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageDao_Impl;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WordLanguageDatabase_Impl extends WordLanguageDatabase {
  private volatile WordLanguageDao _wordLanguageDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `languages` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nativeLanguage` TEXT NOT NULL, `foreignLanguage` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `words` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nativeWord` TEXT NOT NULL, `foreignWord` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `theme` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `isDark` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `results` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `quizName` TEXT NOT NULL, `score` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '38d16a7bc0b6beefc977642889792c2b')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `languages`");
        _db.execSQL("DROP TABLE IF EXISTS `words`");
        _db.execSQL("DROP TABLE IF EXISTS `theme`");
        _db.execSQL("DROP TABLE IF EXISTS `results`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsLanguages = new HashMap<String, TableInfo.Column>(3);
        _columnsLanguages.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLanguages.put("nativeLanguage", new TableInfo.Column("nativeLanguage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLanguages.put("foreignLanguage", new TableInfo.Column("foreignLanguage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLanguages = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLanguages = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLanguages = new TableInfo("languages", _columnsLanguages, _foreignKeysLanguages, _indicesLanguages);
        final TableInfo _existingLanguages = TableInfo.read(_db, "languages");
        if (! _infoLanguages.equals(_existingLanguages)) {
          return new RoomOpenHelper.ValidationResult(false, "languages(uk.ac.aber.dcs.cs31620.languageapp.model.Language).\n"
                  + " Expected:\n" + _infoLanguages + "\n"
                  + " Found:\n" + _existingLanguages);
        }
        final HashMap<String, TableInfo.Column> _columnsWords = new HashMap<String, TableInfo.Column>(3);
        _columnsWords.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWords.put("nativeWord", new TableInfo.Column("nativeWord", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWords.put("foreignWord", new TableInfo.Column("foreignWord", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWords = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWords = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWords = new TableInfo("words", _columnsWords, _foreignKeysWords, _indicesWords);
        final TableInfo _existingWords = TableInfo.read(_db, "words");
        if (! _infoWords.equals(_existingWords)) {
          return new RoomOpenHelper.ValidationResult(false, "words(uk.ac.aber.dcs.cs31620.languageapp.model.Word).\n"
                  + " Expected:\n" + _infoWords + "\n"
                  + " Found:\n" + _existingWords);
        }
        final HashMap<String, TableInfo.Column> _columnsTheme = new HashMap<String, TableInfo.Column>(2);
        _columnsTheme.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTheme.put("isDark", new TableInfo.Column("isDark", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTheme = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTheme = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTheme = new TableInfo("theme", _columnsTheme, _foreignKeysTheme, _indicesTheme);
        final TableInfo _existingTheme = TableInfo.read(_db, "theme");
        if (! _infoTheme.equals(_existingTheme)) {
          return new RoomOpenHelper.ValidationResult(false, "theme(uk.ac.aber.dcs.cs31620.languageapp.model.ThemeMode).\n"
                  + " Expected:\n" + _infoTheme + "\n"
                  + " Found:\n" + _existingTheme);
        }
        final HashMap<String, TableInfo.Column> _columnsResults = new HashMap<String, TableInfo.Column>(3);
        _columnsResults.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResults.put("quizName", new TableInfo.Column("quizName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResults.put("score", new TableInfo.Column("score", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysResults = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesResults = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoResults = new TableInfo("results", _columnsResults, _foreignKeysResults, _indicesResults);
        final TableInfo _existingResults = TableInfo.read(_db, "results");
        if (! _infoResults.equals(_existingResults)) {
          return new RoomOpenHelper.ValidationResult(false, "results(uk.ac.aber.dcs.cs31620.languageapp.model.Results).\n"
                  + " Expected:\n" + _infoResults + "\n"
                  + " Found:\n" + _existingResults);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "38d16a7bc0b6beefc977642889792c2b", "7fd3f3707e0a02615928af882b65407f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "languages","words","theme","results");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `languages`");
      _db.execSQL("DELETE FROM `words`");
      _db.execSQL("DELETE FROM `theme`");
      _db.execSQL("DELETE FROM `results`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(WordLanguageDao.class, WordLanguageDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public WordLanguageDao wordLanguageDao() {
    if (_wordLanguageDao != null) {
      return _wordLanguageDao;
    } else {
      synchronized(this) {
        if(_wordLanguageDao == null) {
          _wordLanguageDao = new WordLanguageDao_Impl(this);
        }
        return _wordLanguageDao;
      }
    }
  }
}
