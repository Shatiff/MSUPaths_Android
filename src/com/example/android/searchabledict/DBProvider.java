package com.example.android.searchabledict;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;


/** DBProvider
 * Queries database to provide search suggestions
 * Currently incomplete, being worked on by Anna
 */
public class DBProvider extends ContentProvider {
    public static String AUTHORITY = "com.example.android.searchabledict.DBProvider";
    private DBAdapter mDB;

    @Override
    public boolean onCreate() {
        mDB = new DBAdapter(getContext());
        mDB.createDatabase();
        mDB.openDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String query = uri.getLastPathSegment().toUpperCase();
        System.out.println(mDB.getBuilding(query).getColumnCount());
        return mDB.getBuilding(query);
    }

    // Necessary for content provider but not implemented
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException();
    }
}
