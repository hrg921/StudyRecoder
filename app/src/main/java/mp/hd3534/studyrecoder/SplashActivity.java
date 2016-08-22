package mp.hd3534.studyrecoder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler hd = new Handler();
        hd.postDelayed(new splashHandler(), 1); // 3초 후에 hd Handler 실행
    }

    private class splashHandler implements Runnable {
        @Override
        public void run() {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            SplashActivity.this.finish(); // 로딩페이지 Activity Stack에서 제거
        }
    }
}