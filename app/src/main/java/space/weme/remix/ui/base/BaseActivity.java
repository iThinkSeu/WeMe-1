package space.weme.remix.ui.base;

import android.app.Activity;

import space.weme.remix.util.OkHttpUtils;

/**
 * Created by Liujilong on 16/1/20.
 * liujilong.me@gmail.com
 */
public abstract class BaseActivity extends Activity {
    /**
     * set the tag for Activity, which may used for cancel okhttp calls
     * @return the tag for this activity;
     */
    protected abstract String tag();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.cancel(tag());
    }
}
