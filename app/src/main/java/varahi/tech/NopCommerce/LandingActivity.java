package varahi.tech.NopCommerce;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        try{
            getSupportActionBar().hide();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        try{
            getActionBar().hide();
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
               /* Intent i = new Intent(LandingActivity.this, MainActivity.class);
                startActivity(i);
                finish();*/
                Intent i = new Intent(LandingActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }

        }, 4000);
    }
}
