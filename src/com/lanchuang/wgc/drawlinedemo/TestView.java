package com.lanchuang.wgc.drawlinedemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

class TestView extends View
{

	public Canvas canvas;
	public Paint p;
	private Bitmap bitmap;
	float x , y;
	int bgColor;

	public TestView(Context context)
	{
		super(context);
		bgColor = Color.WHITE; // ���ñ�����ɫ
		bitmap = Bitmap.createBitmap(480 ,854 ,Bitmap.Config.ARGB_8888); // ����λͼ���߾ͻ���λͼ���棬��һ����������λͼ��͸�
		canvas = new Canvas();
		canvas.setBitmap(bitmap);
		p = new Paint(Paint.DITHER_FLAG);
		p.setAntiAlias(true); // ���ÿ���ݣ�һ����Ϊtrue
		p.setColor(Color.RED); // �����ߵ���ɫ
		p.setStrokeCap(Paint.Cap.ROUND); // �����ߵ�����
		p.setStrokeWidth(8); // �����ߵĿ��

	}

	// �����¼�
	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event )
	{

		if(event.getAction() == MotionEvent.ACTION_MOVE)
		{ // �϶���Ļ
			canvas.drawLine(x ,y ,event.getX() ,event.getY() ,p); // ���ߣ�x��y���ϴε����꣬event.getX(),
			                                                      // event.getY()�ǵ�ǰ����
			invalidate();
		}

		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{ // ������Ļ
			x = event.getX();
			y = event.getY();
			canvas.drawPoint(x ,y ,p); // ����
			invalidate();
		}
		if(event.getAction() == MotionEvent.ACTION_UP)
		{ // �ɿ���Ļ

		}
		x = event.getX(); // ��¼����
		y = event.getY();
		return true;
	}

	@Override
	public void onDraw(Canvas c )
	{
		c.drawBitmap(bitmap ,0 ,0 ,null);
	}
}
