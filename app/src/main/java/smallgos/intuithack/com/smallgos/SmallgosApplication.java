package smallgos.intuithack.com.smallgos;

import android.app.Application;

public class SmallgosApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Network.INSTANCE.init();
    }

}
