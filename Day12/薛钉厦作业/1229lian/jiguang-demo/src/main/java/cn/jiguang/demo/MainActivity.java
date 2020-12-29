package cn.jiguang.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // jshare_click_start
    public void onClickJShare(View v) {
        try{
            Intent intent = new Intent();
            intent.setClassName(getPackageName(),"cn.jiguang.demo.jshare.MainActivity");
            startActivity(intent);
        }catch (Throwable e){
            Toast.makeText(this,"can't find jshare demo",Toast.LENGTH_SHORT).show();
        }
    }
    // jshare_click_end
}
