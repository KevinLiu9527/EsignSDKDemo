package com.rexyn.clientForLease;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends Activity {


    Button clearBtn = null;
    Button signBtn  = null;
    EditText editText = null;


    String key = "91a14e089675854901e6a6c817e15648";
    String license  = "AobUm33PrLOz5eTudbVATDXtyxQupR+0DOENhiFcsCCXnsXblfLlRzCrSrBAr4MB02O6D4" +
            "l1lie1ua82HSsOGTYEMkFmuMdt+utCD2XZSfWzlFgh11s6HKXeP1gb9Te30VdVI4j2S6hU9aDXAjELSnviqpvak8Rzw2pNi" +
            "8gzvTEhZpFbNFWzfN0xexlkXTXpJL1GAwrgJCNJNMKMBSAo4Ml/fu0/bT0mxoSAVs8g1YyNrZVPEGNEmDFcoS1qqssZRXeoJ7" +
            "JegZX3axD6XzD+NURXIXiCXdJa5CDbxIzerRTuNpWsSpNQ9MlrBBCN9vXsieBLmoF1a0uJNxSQO3wBNWh9BXwWlG2YQLeY26" +
            "Li3HZIDZr7Rn13E9H3rgOIaV8+Wqf2M2ySzenCMhCRMMRzamjCdcd+WNMcM3hKjaN6Y1ZvGZzlayuKAqUg9/yvy+TsTdiPBDO" +
            "gZTHFy6jwyrEWA3TA9tPhOXUdwZpEc1IP+IEt8u9UZ1vcvxFj650lfCy6Umhio8+674aQWzyD5t1hzHVeVSyqf9c+X//JG/p" +
            "jqeV65yJQa4SKLud0ixFp1mzvLzA/2be711vsUXdJ5r4v7FpyABJJ8/G1Ckgr502iJ2exqUy45/dnodGVznIuN/+0VGhu" +
            "3V8YfuSkJwxBbSAnMADqH0JEg4WIrM0+egLgTkSb7atmfNYkW0CfUayWI/dhPIG00GlegKOQ" +
            "TO7PX4uF9ElmNOwH7B+B5MLWzScAQykQ3s4zOd1lBH0dHt7jJ0eu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        clearBtn = findViewById(R.id.clear);
        signBtn = findViewById(R.id.sign);
        editText = findViewById(R.id.edit);

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });

        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goSign();
            }
        });




        checkPermission();
    }

    /**
     event.result内容是json格式
     {key:XXX,res:XXX}
     Key代表业务类型对应的值为：sign,realName,will
     sign:签署 realName:实名 will:意愿
     res代表刷脸结果对应的值：fail,success
     fail:失败 success:成功
     */



    private void checkPermission() {
         String[] p = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE};
         EasyPermissions.requestPermissions(this, "本应用需要以下权限，请允许", 0, p);
    }

    private void goSign() {
        String url = editText.getText().toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}