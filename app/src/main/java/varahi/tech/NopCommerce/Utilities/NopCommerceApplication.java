package varahi.tech.NopCommerce.Utilities;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;


@SuppressLint("SimpleDateFormat")
public class NopCommerceApplication extends Application {
	@Override
	public void onCreate() {

		super.onCreate();  

		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread thread, Throwable ex) {
				Log.e("Uncaught Exception","Some Exception occurred in WellBeing360 App" ,ex);
				android.os.Process.killProcess(android.os.Process.myPid());
			}
		});
	}

}
