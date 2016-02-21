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


public class ArchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arch);

        final EditText editText1, editText2;
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        final TextView radiusText = (TextView) findViewById(R.id.radius);

        Button button = (Button) findViewById(R.id.ensureBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double l, h, r;
                if (TextUtils.isEmpty(editText1.getText()) || TextUtils.isEmpty(editText2.getText())){
                    Toast.makeText(ArchActivity.this, "请输入弓形的弦长和高", Toast.LENGTH_SHORT).show();
                    radiusText.setText("0");
                }else {
                    l = Double.valueOf(editText1.getText().toString());
                    h = Double.valueOf(editText2.getText().toString());
                    r = (l * l) / (8 * h) + h / 2;
                    radiusText.setText(MathUtil.round(r) + "");
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_arch, menu);
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
