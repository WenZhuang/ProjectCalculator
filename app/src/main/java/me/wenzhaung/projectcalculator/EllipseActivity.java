package me.wenzhaung.projectcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import me.wenzhaung.Utils.MathUtil;


public class EllipseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ellipse);

        final TextView areaText, periText;

        final EditText editText1, editText2;
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        areaText = (TextView) findViewById(R.id.areaText);
        periText = (TextView) findViewById(R.id.periText);
        Button ensureBtn = (Button) findViewById(R.id.ensureBtn);
        ensureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double radius1, radius2;
                double area;
                double peri;
                if (TextUtils.isEmpty(editText1.getText()) || TextUtils.isEmpty(editText2.getText())){
                    Toast.makeText(EllipseActivity.this,"请输入椭圆的长半轴和短半轴",Toast.LENGTH_SHORT).show();
                    areaText.setText("0");
                    periText.setText("0");
                }else {
                    radius1 = Double.valueOf(editText1.getText().toString());
                    radius2 = Double.valueOf(editText2.getText().toString());
                    area = Math.PI * radius1 * radius2;
                    peri = 2 * Math.PI * radius2 + 4 * (radius1 - radius2);
                    areaText.setText(MathUtil.round(area) + "");
                    periText.setText(MathUtil.round(peri) + "");
                }



            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ellipse, menu);
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
