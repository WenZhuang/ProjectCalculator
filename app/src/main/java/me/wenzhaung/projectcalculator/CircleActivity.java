package me.wenzhaung.projectcalculator;


import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import me.wenzhaung.Utils.LogUtil;
import me.wenzhaung.Utils.MathUtil;


public class CircleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        final TextView areaText, periText;

        areaText = (TextView) findViewById(R.id.areaText);
        periText = (TextView) findViewById(R.id.periText);
        Button ensureBtn = (Button) findViewById(R.id.ensureBtn);
        ensureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText);

                double radius;
                double area;
                double peri;
                if (!TextUtils.isEmpty(editText.getText())) {
                    radius = Double.valueOf(editText.getText().toString());
                    area = Math.PI * radius * radius;
                    peri = 2 * Math.PI * radius;
                    areaText.setText(MathUtil.round(area) + "");
                    periText.setText(MathUtil.round(peri) + "");
                }else {
                    Toast.makeText(CircleActivity.this,"请输入圆的半径",Toast.LENGTH_SHORT).show();
                    areaText.setText("0");
                    periText.setText("0");
                }


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_circle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
