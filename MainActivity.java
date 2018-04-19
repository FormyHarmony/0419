package com.example.harmony.a0411;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity {






    private TextView textresult;
    private ListView lis;
    private Button button;
    private int count;
    public static number number = new number();

    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    //取得介面元件
        number.setnumber();
        button=(Button)findViewById(R.id.button);
        lis=(ListView) findViewById(R.id.list);
        textresult=(TextView)findViewById(R.id.text);


    //以多選範本建立
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,number.number);

        lis.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //設定資料庫來源
        lis.setAdapter(adapter);
        count=adapter.getCount();
        button.setOnClickListener(buttonDo);
        lis.setOnItemClickListener(listen);


    }


    private Button.OnClickListener buttonDo=new Button.OnClickListener(){
        @Override
        public void onClick(View v ){
            String all="";
            for(int p=0;p<count;p++){
                if(lis.isItemChecked(p)){
                    all+=number.number[p]+" , ";

                }
                textresult.setText("總共勾選了"+all);

            }

        }
    };

    private ListView.OnItemClickListener listen=new ListView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String sel=parent.getItemAtPosition(position).toString();
            if(lis.isItemChecked(position))
            {
                setTitle("勾選"+sel);
            }
            else{
                setTitle("清除"+sel);
            }

        }

    };

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_setting) {
            String all="";
            for(int p=0;p<count;p++){
                if(lis.isItemChecked(p)){
                    all+=number.number[p]+" , ";

                }
                textresult.setText("總共勾選了"+all);


            }
            return super.onOptionsItemSelected(item);
        }
        return true;
    }}
