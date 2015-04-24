package util.kite.mester.com.dbflowp1;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by mester on 2015.04.24..
 */
public class DbfflowApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        FlowManager.destroy();
    }

}
