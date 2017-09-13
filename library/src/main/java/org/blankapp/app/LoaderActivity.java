package org.blankapp.app;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import org.blankapp.content.AsyncLoader;
import org.blankapp.util.Log;

import java.util.Random;

public abstract class LoaderActivity<D> extends BaseActivity implements LoaderManager.LoaderCallbacks<D>, AsyncLoader.LoaderCallback<D> {
    private final String TAG = LoaderActivity.class.getSimpleName();

    protected final int LOADER_ID = new Random().nextInt();

    protected LoaderManager mLoaderManager;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.destroyLoader();
    }

    protected void ensureLoaderManager() {
        if (mLoaderManager == null) {
            mLoaderManager = getSupportLoaderManager();
        }
        LoaderManager.enableDebugLogging(true);
    }

    protected void initLoader() {
        Log.e(TAG, String.format(">>>initLoader(%d)", LOADER_ID));
        ensureLoaderManager();
        mLoaderManager.initLoader(LOADER_ID, null, this);
    }

    public void restartLoader() {
        Log.e(TAG, String.format(">>>restartLoader(%d)", LOADER_ID));
        ensureLoaderManager();
        mLoaderManager.restartLoader(LOADER_ID, null, this);
    }

    public void destroyLoader() {
        Log.e(TAG, String.format(">>>destroyLoader(%d)", LOADER_ID));
        ensureLoaderManager();
        mLoaderManager.destroyLoader(LOADER_ID);
    }

    protected void startLoading() {
        ensureLoaderManager();
        AsyncLoader<D> asyncLoader = (AsyncLoader<D>) mLoaderManager.getLoader(LOADER_ID);
        asyncLoader.startLoading();
    }

    protected void stopLoading() {
        ensureLoaderManager();
        AsyncLoader<D> asyncLoader = (AsyncLoader<D>) mLoaderManager.getLoader(LOADER_ID);
        asyncLoader.stopLoading();
    }

    protected void forceLoad() {
        ensureLoaderManager();
        AsyncLoader<D> asyncLoader = (AsyncLoader<D>) mLoaderManager.getLoader(LOADER_ID);
        asyncLoader.forceLoad();
    }

    @Override
    public Loader<D> onCreateLoader(int id, Bundle args) {
        Log.d(TAG, ">>>onCreateLoader");
        return new AsyncLoader<D>(this, this);
    }

    @Deprecated
    @Override
    public void onLoadFinished(Loader<D> loader, D data) {
        Log.d(TAG, ">>>onLoadFinished");
    }

    @Deprecated
    @Override
    public void onLoaderReset(Loader<D> loader) {
        Log.d(TAG, ">>>onLoaderReset");
    }

}
