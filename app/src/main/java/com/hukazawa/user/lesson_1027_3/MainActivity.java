package com.hukazawa.user.lesson_1027_3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int tmp,ch=-1;
    boolean chks[] = new boolean[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickdialog(View v)
    {
        AlertDialog.Builder bui = new AlertDialog.Builder(MainActivity.this);
        bui.setTitle("標題");
        bui.setMessage("內文");
        bui.setPositiveButton("ok", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this, "按確定", Toast.LENGTH_SHORT).show();
            }
        });
        bui.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按取消", Toast.LENGTH_SHORT).show();
            }
        });
        bui.setNeutralButton("pass",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "略過", Toast.LENGTH_SHORT).show();
            }
        });
        bui.show();
    }

    public void clickinput(View v)
    {
        AlertDialog.Builder bui = new AlertDialog.Builder(MainActivity.this);
        bui.setTitle("標題");
        bui.setMessage("請輸入內容");
        final EditText ed = new EditText(MainActivity.this);
        bui.setView(ed);
        bui.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "輸入為:"+ed.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        bui.show();
    }

    public void clickch(View v)
    {
        AlertDialog.Builder bui = new AlertDialog.Builder(MainActivity.this);
        bui.setTitle("購買項目");
        tmp=ch;
        bui.setSingleChoiceItems(R.array.top,tmp,new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tmp=which;
            }
        });
        bui.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (tmp>=0)
                {
                    String[] str = getResources().getStringArray(R.array.top);
                    TextView tv = (TextView)findViewById(R.id.textView2);
                    ch=tmp;
                    tv.setText(str[ch]);
                }

            }
        });

        bui.show();
    }

    public void clickset(View v)
    {
        AlertDialog.Builder bui = new AlertDialog.Builder(MainActivity.this);
        bui.setTitle("購買項目");
        bui.setItems(R.array.top,new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String[] str = getResources().getStringArray(R.array.top);
                TextView tv3 = (TextView) findViewById(R.id.textView3);
                tv3.setText(str[which]);

            }
        });


        bui.show();
    }

    public void clickmu(View v)
    {
        AlertDialog.Builder bui = new AlertDialog.Builder(MainActivity.this);
        bui.setTitle("購買項目");
        bui.setMultiChoiceItems(R.array.top,chks,new DialogInterface.OnMultiChoiceClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which,boolean isChecked) {

            }
        });
        bui.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String[] str3 = getResources().getStringArray(R.array.top);
                TextView tv4 = (TextView)findViewById(R.id.textView4);
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<=3;i++)
                {
                    if(chks[i])
                    {
                        sb.append(str3[i]+"-");
                    }
                }
                tv4.setText(sb);

            }
        });
        bui.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        bui.show();
    }
}

