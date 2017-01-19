package in.ac.iitd.ees.eesquizbuzzer;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by akedia on 17/02/16.
 */
public class EesQuizBuzzer extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
