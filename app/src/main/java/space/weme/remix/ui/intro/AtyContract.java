package space.weme.remix.ui.intro;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;

import space.weme.remix.R;

/**
 * Created by Liujilong on 16/2/3.
 * liujilong.me@gmail.com
 */
public class AtyContract extends Activity {
    TextView tvContract;
    TextView tvReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_contract);
        Toolbar toolbar = (Toolbar) findViewById(R.id.aty_contract_toolbar);
        toolbar.setTitle(R.string.user_contract);
        toolbar.setTitleTextColor(Color.WHITE);
        tvContract = (TextView) findViewById(R.id.aty_contract_text);
        tvReturn = (TextView) findViewById(R.id.aty_contract_return);
        tvReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        new Thread(){
            @Override
            public void run() {
                final String res;
                try{
                    InputStream in = getResources().openRawResource(R.raw.contract);
                    int length = in.available();

                    byte [] buffer = new byte[length];
                    in.read(buffer);
                    res = new String(buffer,"utf-8");
                    in.close();
                    tvContract.post(new Runnable() {
                        @Override
                        public void run() {
                            tvContract.setText(res);
                        }
                    });
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        }.run();
    }

}
