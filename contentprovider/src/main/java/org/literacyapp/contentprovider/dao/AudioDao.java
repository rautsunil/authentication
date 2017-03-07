package org.literacyapp.contentprovider.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import java.util.Calendar;
import java.util.Set;
import org.literacyapp.contentprovider.dao.converter.AudioFormatConverter;
import org.literacyapp.contentprovider.dao.converter.CalendarConverter;
import org.literacyapp.contentprovider.dao.converter.ContentStatusConverter;
import org.literacyapp.contentprovider.dao.converter.LocaleConverter;
import org.literacyapp.contentprovider.dao.converter.StringSetConverter;
import org.literacyapp.model.enums.Locale;
import org.literacyapp.model.enums.content.AudioFormat;
import org.literacyapp.model.enums.content.ContentStatus;

import org.literacyapp.contentprovider.model.content.multimedia.Audio;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "AUDIO".
*/
public class AudioDao extends AbstractDao<Audio, Long> {

    public static final String TABLENAME = "AUDIO";

    /**
     * Properties of entity Audio.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Locale = new Property(1, String.class, "locale", false, "LOCALE");
        public final static Property TimeLastUpdate = new Property(2, Long.class, "timeLastUpdate", false, "TIME_LAST_UPDATE");
        public final static Property RevisionNumber = new Property(3, Integer.class, "revisionNumber", false, "REVISION_NUMBER");
        public final static Property ContentStatus = new Property(4, String.class, "contentStatus", false, "CONTENT_STATUS");
        public final static Property ContentType = new Property(5, String.class, "contentType", false, "CONTENT_TYPE");
        public final static Property LiteracySkills = new Property(6, String.class, "literacySkills", false, "LITERACY_SKILLS");
        public final static Property NumeracySkills = new Property(7, String.class, "numeracySkills", false, "NUMERACY_SKILLS");
        public final static Property Transcription = new Property(8, String.class, "transcription", false, "TRANSCRIPTION");
        public final static Property AudioFormat = new Property(9, String.class, "audioFormat", false, "AUDIO_FORMAT");
    }

    private DaoSession daoSession;

    private final LocaleConverter localeConverter = new LocaleConverter();
    private final CalendarConverter timeLastUpdateConverter = new CalendarConverter();
    private final ContentStatusConverter contentStatusConverter = new ContentStatusConverter();
    private final StringSetConverter literacySkillsConverter = new StringSetConverter();
    private final StringSetConverter numeracySkillsConverter = new StringSetConverter();
    private final AudioFormatConverter audioFormatConverter = new AudioFormatConverter();

    public AudioDao(DaoConfig config) {
        super(config);
    }
    
    public AudioDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"AUDIO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"LOCALE\" TEXT NOT NULL ," + // 1: locale
                "\"TIME_LAST_UPDATE\" INTEGER," + // 2: timeLastUpdate
                "\"REVISION_NUMBER\" INTEGER NOT NULL ," + // 3: revisionNumber
                "\"CONTENT_STATUS\" TEXT NOT NULL ," + // 4: contentStatus
                "\"CONTENT_TYPE\" TEXT NOT NULL ," + // 5: contentType
                "\"LITERACY_SKILLS\" TEXT," + // 6: literacySkills
                "\"NUMERACY_SKILLS\" TEXT," + // 7: numeracySkills
                "\"TRANSCRIPTION\" TEXT NOT NULL ," + // 8: transcription
                "\"AUDIO_FORMAT\" TEXT NOT NULL );"); // 9: audioFormat
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"AUDIO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Audio entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, localeConverter.convertToDatabaseValue(entity.getLocale()));
 
        Calendar timeLastUpdate = entity.getTimeLastUpdate();
        if (timeLastUpdate != null) {
            stmt.bindLong(3, timeLastUpdateConverter.convertToDatabaseValue(timeLastUpdate));
        }
        stmt.bindLong(4, entity.getRevisionNumber());
        stmt.bindString(5, contentStatusConverter.convertToDatabaseValue(entity.getContentStatus()));
        stmt.bindString(6, entity.getContentType());
 
        Set literacySkills = entity.getLiteracySkills();
        if (literacySkills != null) {
            stmt.bindString(7, literacySkillsConverter.convertToDatabaseValue(literacySkills));
        }
 
        Set numeracySkills = entity.getNumeracySkills();
        if (numeracySkills != null) {
            stmt.bindString(8, numeracySkillsConverter.convertToDatabaseValue(numeracySkills));
        }
        stmt.bindString(9, entity.getTranscription());
        stmt.bindString(10, audioFormatConverter.convertToDatabaseValue(entity.getAudioFormat()));
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Audio entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, localeConverter.convertToDatabaseValue(entity.getLocale()));
 
        Calendar timeLastUpdate = entity.getTimeLastUpdate();
        if (timeLastUpdate != null) {
            stmt.bindLong(3, timeLastUpdateConverter.convertToDatabaseValue(timeLastUpdate));
        }
        stmt.bindLong(4, entity.getRevisionNumber());
        stmt.bindString(5, contentStatusConverter.convertToDatabaseValue(entity.getContentStatus()));
        stmt.bindString(6, entity.getContentType());
 
        Set literacySkills = entity.getLiteracySkills();
        if (literacySkills != null) {
            stmt.bindString(7, literacySkillsConverter.convertToDatabaseValue(literacySkills));
        }
 
        Set numeracySkills = entity.getNumeracySkills();
        if (numeracySkills != null) {
            stmt.bindString(8, numeracySkillsConverter.convertToDatabaseValue(numeracySkills));
        }
        stmt.bindString(9, entity.getTranscription());
        stmt.bindString(10, audioFormatConverter.convertToDatabaseValue(entity.getAudioFormat()));
    }

    @Override
    protected final void attachEntity(Audio entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Audio readEntity(Cursor cursor, int offset) {
        Audio entity = new Audio( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            localeConverter.convertToEntityProperty(cursor.getString(offset + 1)), // locale
            cursor.isNull(offset + 2) ? null : timeLastUpdateConverter.convertToEntityProperty(cursor.getLong(offset + 2)), // timeLastUpdate
            cursor.getInt(offset + 3), // revisionNumber
            contentStatusConverter.convertToEntityProperty(cursor.getString(offset + 4)), // contentStatus
            cursor.getString(offset + 5), // contentType
            cursor.isNull(offset + 6) ? null : literacySkillsConverter.convertToEntityProperty(cursor.getString(offset + 6)), // literacySkills
            cursor.isNull(offset + 7) ? null : numeracySkillsConverter.convertToEntityProperty(cursor.getString(offset + 7)), // numeracySkills
            cursor.getString(offset + 8), // transcription
            audioFormatConverter.convertToEntityProperty(cursor.getString(offset + 9)) // audioFormat
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Audio entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setLocale(localeConverter.convertToEntityProperty(cursor.getString(offset + 1)));
        entity.setTimeLastUpdate(cursor.isNull(offset + 2) ? null : timeLastUpdateConverter.convertToEntityProperty(cursor.getLong(offset + 2)));
        entity.setRevisionNumber(cursor.getInt(offset + 3));
        entity.setContentStatus(contentStatusConverter.convertToEntityProperty(cursor.getString(offset + 4)));
        entity.setContentType(cursor.getString(offset + 5));
        entity.setLiteracySkills(cursor.isNull(offset + 6) ? null : literacySkillsConverter.convertToEntityProperty(cursor.getString(offset + 6)));
        entity.setNumeracySkills(cursor.isNull(offset + 7) ? null : numeracySkillsConverter.convertToEntityProperty(cursor.getString(offset + 7)));
        entity.setTranscription(cursor.getString(offset + 8));
        entity.setAudioFormat(audioFormatConverter.convertToEntityProperty(cursor.getString(offset + 9)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Audio entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Audio entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Audio entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}