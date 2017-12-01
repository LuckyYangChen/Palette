package com.example.kevin;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.kevin.canvas.CustomDrawView;

public class MainActivity extends AppCompatActivity {

    EmbossMaskFilter emboss;
    BlurMaskFilter blur;
    CustomDrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = new LinearLayout(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            // 创建一个DrawView，宽度和高度全屏
            drawView = new CustomDrawView(this, displayMetrics.widthPixels, displayMetrics.heightPixels);
            linearLayout.addView(drawView);
            setContentView(linearLayout);

            emboss = new EmbossMaskFilter(new float[]{1.5f, 1.5f, 1.5f}, 0.6f, 6, 4.2f);

            blur = new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL);
        }

    }

    // 负责创建选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        // 加载R.menu.my_menu对应的菜单，并添加到menu中，
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.red:
                drawView.paint.setColor(Color.RED);
                break;
            case R.id.green:
                drawView.paint.setColor(Color.GREEN);
                break;
            case R.id.blue:
                drawView.paint.setColor(Color.BLUE);
                break;
            case R.id.width_1:
                drawView.paint.setStrokeWidth(5);
                break;
            case R.id.width_3:
                drawView.paint.setStrokeWidth(10);
                break;
            case R.id.width_5:
                drawView.paint.setStrokeWidth(15);
                break;
            case R.id.normal:
                drawView.paint.setMaskFilter(null);
            case R.id.blur:
                drawView.paint.setMaskFilter(blur);
                break;
            case R.id.emboss:
                drawView.paint.setMaskFilter(emboss);
                break;
        }
        return true;
    }
}