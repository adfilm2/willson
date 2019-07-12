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

public class TwoTextTwoButton_CustomDialog extends Dialog {

    private TextView L_textview;
    private TextView s_textview;
    private Button ok_btn;
    private TextView little_textview;

    private String alart_text_1;
    private String alart_text_2;
    private String keep_btn_text;
    private String exit_btn_text;

    private View.OnClickListener ok_btn_listener;
    private View.OnClickListener exit_listener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_popup_timeout);

        WindowManager.LayoutParams window = new WindowManager.LayoutParams();
        window.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.dimAmount = 0.8f;
        getWindow().setAttributes(window);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        L_textview = findViewById(R.id.request_pop_textview_large);
        s_textview = findViewById(R.id.request_pop_textview_small);
        ok_btn = findViewById(R.id.request_pop_keepbtn);
        ok_btn.setOnClickListener(ok_btn_listener);
        little_textview = findViewById(R.id.list_pop_exitbtn);
        little_textview.setOnClickListener(exit_listener);

        ok_btn.setText(keep_btn_text);
        L_textview.setText(alart_text_1);
        s_textview.setText(alart_text_2);
        little_textview.setText(exit_btn_text);
    }


    public TwoTextTwoButton_CustomDialog(Context context, String text_1, String text_2, String btn, String little, View.OnClickListener keep_listener, View.OnClickListener exit_listener) {
        super(context);

        this.alart_text_1 = text_1;
        this.alart_text_2 = text_2;
        this.keep_btn_text = btn;
        this.exit_btn_text = little;
        this.ok_btn_listener = keep_listener;
    }

}
