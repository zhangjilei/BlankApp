package org.blankapp.examples;

import android.os.Bundle;
import android.widget.Button;

import org.blankapp.BlankApp;
import org.blankapp.annotation.ViewById;
import org.blankapp.app.LoaderActivity;
import org.blankapp.util.Log;

public class MainActivity extends LoaderActivity<Object> {
    private final String TAG = MainActivity.class.getSimpleName();

    @ViewById(R.id.start)
    private Button start;

    private boolean needError = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlankApp.initialize(this, true);

        this.initLoader();

//        runOnUiThread(() -> Log.i("TAG", "test"));
//
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                Log.i("TAG", "test");
//            }
//        });
//
//        findViewById(R.id.entry_list).setOnClickListener(v -> {
//            Intent intent = new Intent(this, SimpleListActivity.class);
//            startActivity(intent);
//        });
//        findViewById(R.id.entry_grid).setOnClickListener(v -> {
//            Intent intent = new Intent(this, SimpleGridActivity.class);
//            startActivity(intent);
//        });
//
//        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                needError = !needError;
//                Log.e(TAG, "needError:" + needError);
////                mLoaderManager.getLoader(LOADER_ID).onContentChanged();
//                forceLoad();
//                new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("BlankApp")
//                        .setMessage("hello !")
//                        .setNegativeButton("Ok", null)
//                        .setPositiveButton("Cancel", null)
//                        .create()
//                        .show();
//            }
//        });
//        findViewById(R.id.dialog).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AppCompatDialog appCompatDialog = new AppCompatDialog(MainActivity.this);
//                appCompatDialog.setTitle("你好");
//                appCompatDialog.setContentView(R.layout.test_dialog);
//                appCompatDialog.show();
//            }
//        });
    }

    @Override
    public void onLoadStart() {
        Log.e(TAG, ">>>onLoadStart");
    }

    @Override
    public Object onLoadInBackground() throws Exception {
        Log.e(TAG, ">>>onLoadInBackground");

        if (needError) {
            throw new NullPointerException("error");
        }

        return new Object();
    }

    @Override
    public void onLoadComplete(Object data) {
        Log.e(TAG, ">>>onLoadComplete");
    }

    @Override
    public void onLoadError(Exception e) {
        Log.e(TAG, ">>>onLoadFailure");
        e.printStackTrace();
    }
}
