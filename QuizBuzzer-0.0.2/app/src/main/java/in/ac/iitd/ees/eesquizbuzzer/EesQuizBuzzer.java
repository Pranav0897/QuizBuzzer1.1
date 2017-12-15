package in.ac.iitd.ees.eesquizbuzzer;

import android.app.Application;

import com.firebase.client.Firebase;


public class EesQuizBuzzer extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
