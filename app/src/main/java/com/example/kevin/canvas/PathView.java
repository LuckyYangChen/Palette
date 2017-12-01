package com.example.kevin.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.view.View;

/**
 * 作者：Kevin 时间：2017/10/30
 * 类说明：自定义View实现路径效果
 */

public class PathView extends View {

    float phase;
    PathEffect[] effects = new PathEffect[7];
    int[] colors;
    private Paint paint;
    Path path;

    public PathView(Context context) {
        super(context);
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        // 创建并初始化path
        path = new Path();
        path.moveTo(10, 0);
        for (int i = 1; i <= 30; i++) {
            // 生成40个点，随机生成它们的Y坐标，并把他们连接成一条path
            path.lineTo(i * 20, (float) Math.random() * 60);
        }
        // 初始化7个颜色
        colors = new int[]{Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.RED, Color.BLACK};
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        // 下面开始初始化7种路径效果
        // 不使用路径效果
        effects[0] = null;
        // 使用CornerPathEffect路径效果，带圆角的
        effects[1] = new CornerPathEffect(10);
        // 初始化DiscretePathEffect, 离散效果，不连续的
        effects[2] = new DiscretePathEffect(3.0f, 5.0f);
        // 初始化DashPathEffect，虚线效果
        effects[3] = new DashPathEffect(new float[]{20, 10, 5, 10}, phase);
        // 初始化PathDashPathEffect
        Path p = new Path();
        p.addRect(0, 0, 8, 8, Path.Direction.CCW);
        effects[4] = new PathDashPathEffect(p, 12, phase, PathDashPathEffect.Style.ROTATE);
        // 初始化ComposePathEffect，组合效果，没有先后，只有内外之分
        effects[5] = new ComposePathEffect(effects[2], effects[4]);
        // 有先后效果之分
        effects[6] = new SumPathEffect(effects[4], effects[3]);
        // 将画布移动到（8，8）处开始执行
        canvas.translate(8, 8);
        // 依次使用7种不同的颜色会绘制路径
        for (int i = 0; i < effects.length; i++) {
            paint.setPathEffect(effects[i]);
            paint.setColor(colors[i]);
            canvas.drawPath(path, paint);
            canvas.translate(0, 80);
        }
        // 改变phase值，形成动画效果
        phase -= 1;
        invalidate();
    }

}