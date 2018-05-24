package com.example.gl_10_test326;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

public class GLCube {
	private  final IntBuffer mVertexBuffer;//顶点坐标数据缓冲
	private IntBuffer mTextureBuffer;//纹理贴图数据缓冲
		public GLCube(){
			int one=65536;
			int half=one/2;
			int vertices[]={//定义顶点位置
				//前面
					-half,-half, half, half,-half, half,
					-half, half, half, half, half, half,
				//后面
					-half,-half,-half,-half, half,-half,
					 half,-half,-half, half, half,-half,
				//左面
					-half,-half, half,-half, half, half,
					-half,-half,-half,-half, half,-half,
				//右面
					 half,-half,-half, half, half,-half,
					 half,-half, half, half, half, half,
				//上面
					-half, half, half, half, half, half,
					-half, half,-half, half, half,-half,
				//下面
					-half,-half, half,-half,-half,-half,
					 half,-half, half, half,-half,-half,
			};
			//创建顶点坐标数据缓冲
			ByteBuffer vbb=ByteBuffer.allocateDirect(vertices.length*4);
			vbb.order(ByteOrder.nativeOrder());//设置字节顺序
			mVertexBuffer=vbb.asIntBuffer();//转换为int型缓冲
			mVertexBuffer.put(vertices);//向缓冲中放入顶点坐标数据
			mVertexBuffer.position(0);//设置缓冲区的起始位置
			/**    纹理贴图     */
			int texCoords[]={//定义贴图坐标数据
				//前面
					0,one,one,one,0,0,one,0,
				//后面
					one,one,one,0,0,one,0,0,
				//左面
					one,one,one,0,0,one,0,0,
				//右面
					one,one,one,0,0,one,0,0,
				//上面
					one,0,0,0,one,one,0,one,
				//下面
					0,0,0,one,one,0,one,one,
			};
			ByteBuffer tbb=ByteBuffer.allocateDirect(texCoords.length*4);
			tbb.order(ByteOrder.nativeOrder());//设置字节顺序
			mTextureBuffer=tbb.asIntBuffer();//转换为int型缓冲
			mTextureBuffer.put(texCoords);//向缓冲中放入贴图坐标数据
			mTextureBuffer.position(0);//设置缓冲区的起始位置
			
	}
		public void draw(GL10 gl){
			gl.glVertexPointer(3, GL10.GL_FIXED, 0, mVertexBuffer);//为画笔指定顶点坐标数据
			//绘制FRONT和BACK两个面
			gl.glColor4f(1, 1, 1, 1);
			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);//绘制图形	
			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 4, 4);//绘制图形
			//绘制left和right两个面
			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 8, 4);//绘制图形
			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 12, 4);//绘制图形
			//绘制top和bottom两个面
			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 16, 4);//绘制图形
			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 20, 4);//绘制图形
		}
		/**    进行纹理贴图     */
	public void loadTexture(GL10 gl, Context context, int resources) {
		// TODO Auto-generated method stub
		Bitmap bmp=BitmapFactory.decodeResource(context.getResources(), resources);//加载位图
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D,0,bmp,0);//使用图片生产纹理
		bmp.recycle();//释放资源
	}
}
