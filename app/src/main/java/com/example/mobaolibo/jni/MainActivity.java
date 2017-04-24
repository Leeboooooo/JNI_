package com.example.mobaolibo.jni;

import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobaolibo.jni.bsdiff.PatchUtils;
import com.example.mobaolibo.jni.utils.ApkUtils;

public class MainActivity extends AppCompatActivity {
    private ProgressBar loading;
    private String srcDir = "";
    private String newDir = "";
    private String patchDir = "";

    // 成功
    private static final int WHAT_SUCCESS = 1;
    // 失败
    private static final int WHAT_FAIL_PATCH = 0;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        loading = (ProgressBar) findViewById(R.id.loadding);
        srcDir = ApkUtils.getApkPath(this);
        newDir = ApkUtils.getNewApkPath();
        patchDir = ApkUtils.getPatch();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public void onClickStatic(View view){
        AndroidJni.getInstance().staticLog();
    }

    public void onClickDynamic(View view){
//        AndroidJni.getInstance().dynamicLog();
        loading.setVisibility(View.VISIBLE);
        new PatchTask().execute();
    }

    public void patch(View view){
        loading.setVisibility(View.VISIBLE);
        new PatchTask().execute();
    }


    public class PatchTask extends AsyncTask<String, Void, Integer> {
        @Override
        protected Integer doInBackground(String... params) {
            try {

                int result = PatchUtils.getInstance().patch(srcDir, newDir, patchDir);
                if (result == 0) {
                    handler.obtainMessage(1).sendToTarget();
                    return WHAT_SUCCESS;
                } else {
                    handler.obtainMessage(2).sendToTarget();
                    return WHAT_FAIL_PATCH;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return WHAT_FAIL_PATCH;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            loading.setVisibility(View.GONE);
        }
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Toast.makeText(getApplicationContext(), "failures", Toast.LENGTH_SHORT).show();
                    //do anything
                    break;
                case 1:
                    Toast.makeText(getApplicationContext(), "patch successed", Toast.LENGTH_SHORT).show();
                    //do anything
                    break;
                case 2:
                    Toast.makeText(getApplicationContext(), "patch failures", Toast.LENGTH_SHORT).show();
                    //do anything
                    break;
                default:
                    break;
            }
        }
    };
}
