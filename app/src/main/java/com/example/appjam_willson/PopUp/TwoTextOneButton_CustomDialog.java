package com.example.appjam_willson.PopUp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.appjam_willson.R;

public class TwoTextOneButton_CustomDialog extends Dialog {

    private TextView L_textview;
    private TextView s_textview;
    private Button ok_btn;

    private String alart_text_1;
    private String alart_text_2;
    private String keep_btn_text;

    private View.OnClickListener ok_btn_listener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams window = new WindowManager.LayoutParams();
        window.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.dimAmount = 0.8f;
        getWindow().setAttributes(window);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_request_already_match);

        L_textview = findViewById(R.id.request_pop_textview_large);
        s_textview = findViewById(R.id.request_pop_textview_small);
        ok_btn = findViewById(R.id.request_pop_keepbtn);
        ok_btn.setOnClickListener(ok_btn_listener);

        ok_btn.setText(keep_btn_text);
        L_textview.setText(alart_text_1);
        s_textview.setText(alart_text_2);
    }


    public TwoTextOneButton_CustomDialog(Context context, String text_1, String text_2, String btn, View.OnClickListener keep_listener) {
        super(context);

        this.alart_text_1 = text_1;
        this.alart_text_2 = text_2;
        this.keep_btn_text = btn;
        this.ok_btn_listener = keep_listener;
    }

}
