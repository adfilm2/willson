package com.example.appjam_willson.PopUp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appjam_willson.R;

public class CustomDialog extends Dialog {

    private ImageView wilson_image;
    private TextView alart_textview;
    private Button keep_btn;
    private TextView exit_btn;

    private int image_id;
    private String alart_text;
    private String keep_btn_text;
    private String exit_btn_text;

    private View.OnClickListener exit_btn_listener;
    private View.OnClickListener keep_btn_listener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams window = new WindowManager.LayoutParams();
        window.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.dimAmount = 0.8f;
        getWindow().setAttributes(window);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_list_popup);

//        wilson_image = (ImageView) findViewById(R.id.list_pop_image);
        alart_textview = (TextView) findViewById(R.id.list_pop_textview);
        keep_btn = (Button) findViewById(R.id.list_pop_keepbtn);
        exit_btn = (TextView) findViewById(R.id.list_pop_exitbtn);

        wilson_image.setImageResource(image_id);
        alart_textview.setText(alart_text);
        keep_btn.setText(keep_btn_text);
        exit_btn.setText(exit_btn_text);

        keep_btn.setOnClickListener(keep_btn_listener);
        exit_btn.setOnClickListener(exit_btn_listener);

    }

    public CustomDialog(Context context, int image, String text, String keep_text, String exit_text, View.OnClickListener keep_listener, View.OnClickListener exit_listener) {
        super(context);

        this.image_id = image;
        this.alart_text = text;
        this.keep_btn_text= keep_text;
        this.exit_btn_text = exit_text;
        this.keep_btn_listener = keep_listener;
        this.exit_btn_listener = exit_listener;
    }


}
