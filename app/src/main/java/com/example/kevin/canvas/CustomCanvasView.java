package com.example.kevin.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 作者：Kevin 时间：2017/10/26
 * 类说明：自定义View
 */

public class CustomCanvasView extends View {

    public CustomCanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 把整张画布绘制成红色
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        /************** 设置渐变器 **************/
//        Shader mShader = new LinearGradient(0, 0, 40, 60, new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW}, null, Shader.TileMode.MIRROR);
//        paint.setShader(mShader);
//        paint.setShadowLayer(25, 20, 20, Color.GRAY);
        /************** 设置渐变器 **************/
        int viewWidth = this.getWidth();
        Log.i("onDraw", "========>" + viewWidth);
        // 绘制圆形
        canvas.drawCircle(viewWidth / 10 + 10, viewWidth / 10 + 10, viewWidth / 10, paint);
        // 绘制正方形
        canvas.drawRect(10, viewWidth / 5 + 20, viewWidth / 5 + 10, viewWidth * 2 / 5 + 20, paint);
        // 绘制矩形
        canvas.drawRect(10, viewWidth * 2 / 5 + 30, viewWidth / 5 + 10, viewWidth / 2 + 30, paint);

        RectF re1 = new RectF(10, viewWidth / 2 + 40, viewWidth / 5 + 10, viewWidth * 3 / 5 + 40);
        // 绘制圆角矩形
        canvas.drawRoundRect(re1, 15, 15, paint);

        RectF re2 = new RectF(10, viewWidth * 3 / 5 + 50, viewWidth / 5 + 10, viewWidth * 7 / 10 + 50);
        // 绘制椭圆
        canvas.drawOval(re2, paint);

        // 定义一个Path对象，封闭成一个三角形
        Path path1 = new Path();
        // 左下角
        path1.moveTo(10, viewWidth * 9 / 10 + 60);
        // 右下角
        path1.lineTo(viewWidth / 5 + 10, viewWidth * 9 / 10 + 60);
        // 顶点
        path1.lineTo(viewWidth / 10 + 10, viewWidth * 7 / 10 + 60);
        path1.close();
        // 根据path进行绘制，封闭成一个三角形
        canvas.drawPath(path1, paint);

        Path path2 = new Path();
        // 顶点
        path2.moveTo(10, viewWidth);
        // 右下角
        path2.lineTo(viewWidth / 5 + 10, viewWidth * 1.1f + 60);
        // 左下角
        path2.lineTo(10, viewWidth * 1.1f + 60);
        path2.close();
        // 根据path2进行绘制，封闭成一个直角三角形
        canvas.drawPath(path2, paint);

    }
}