/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package me.wenzhaung.projectcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import me.wenzhaung.Utils.MathUtil;

/*
 * MainActivity class that loads MainFragment
 */
public class TrapActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trap);

        final EditText editText1, editText2, editText3;
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        final TextView areaText = (TextView) findViewById(R.id.areaText);
        Button button = (Button) findViewById(R.id.ensureBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a, b, h;
                if (TextUtils.isEmpty(editText1.getText())
                        ||TextUtils.isEmpty(editText2.getText())
                        ||TextUtils.isEmpty(editText3.getText())){
                    Toast.makeText(TrapActivity.this, "请输入梯形的上底下底和高", Toast.LENGTH_SHORT).show();
                    areaText.setText("0");
                }else {
                    a = Double.valueOf(editText1.getText().toString());
                    b = Double.valueOf(editText2.getText().toString());
                    h = Double.valueOf(editText3.getText().toString());
                    double s = ((a + b) * h) / 2;
                    areaText.setText(MathUtil.round(s) + "");
                }
            }
        });
    }
}
