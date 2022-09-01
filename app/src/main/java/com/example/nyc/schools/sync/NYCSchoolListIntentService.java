
///region Import Namespace
package com.example.nyc.schools.sync;

import android.app.IntentService;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import androidx.annotation.Nullable;
import android.util.Log;
//endregion

public class NYCSchoolListIntentService extends IntentService {

    //region Variable
    private static final String CLASS_NAME = NYCSchoolListIntentService.class.getSimpleName();
    //endregion

    //region Public Constructors
    public NYCSchoolListIntentService() {
        super("NYCSchoolListIntentService");
    }
    //endregion

    //region Override
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            boolean isSchool = false;
            if (intent.hasExtra(Intent.EXTRA_TEXT))
                isSchool = intent.getExtras().getBoolean(Intent.EXTRA_TEXT);
            NYCSchoolListSyncTask.syncNYCSchoolData(this, isSchool);
        } catch (SQLiteException e) {
            Log.e(CLASS_NAME, "bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) - NYC_SCHOOL_DETAIL_ID" + e.getMessage());
        }
    }
    //endregion


}
