package ac.kr.seowon.project13_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2;
    ProgressBar pb1, pb2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        pb1 = (ProgressBar) findViewById(R.id.pb1);
        pb2 = (ProgressBar) findViewById(R.id.pb2);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    public void run() {
                        for (int i = pb1.getProgress(); i < 100; i = i+2) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    pb1.setProgress(pb1.getProgress() + 2);
                                    tv1.setText("1번 진행률 : " + pb1.getProgress() + "%");
                                }
                            });
                            SystemClock.sleep(100);
                        }
                    }
                }.start();
                new Thread() {
                    public void run() {
                        for (int i = pb2.getProgress(); i < 100; i = i+2) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    pb2.setProgress(pb2.getProgress() + 2);
                                    tv2.setText("2번 진행률 : " + pb2.getProgress() + "%");
                                }
                            });
                            SystemClock.sleep(100);
                        }
                    }
                }.start();
            }
        });
    }
}