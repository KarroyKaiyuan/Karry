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
	private  final IntBuffer mVertexBuffer;//�����������ݻ���
	private IntBuffer mTextureBuffer;//������ͼ���ݻ���
		public GLCube(){
			int one=65536;
			int half=one/2;
			int vertices[]={//���嶥��λ��
				//ǰ��
					-half,-half, half, half,-half, half,
					-half, half, half, half, half, half,
				//����
					-half,-half,-half,-half, half,-half,
					 half,-half,-half, half, half,-half,
				//����
					-half,-half, half,-half, half, half,
					-half,-half,-half,-half, half,-half,
				//����
					 half,-half,-half, half, half,-half,
					 half,-half, half, half, half, half,
				//����
					-half, half, half, half, half, half,
					-half, half,-half, half, half,-half,
				//����
					-half,-half, half,-half,-half,-half,
					 half,-half, half, half,-half,-half,
			};
			//���������������ݻ���
			ByteBuffer vbb=ByteBuffer.allocateDirect(vertices.length*4);
			vbb.order(ByteOrder.nativeOrder());//�����ֽ�˳��
			mVertexBuffer=vbb.asIntBuffer();//ת��Ϊint�ͻ���
			mVertexBuffer.put(vertices);//�򻺳��з��붥����������
			mVertexBuffer.position(0);//���û���������ʼλ��
			/**    ������ͼ     */
			int texCoords[]={//������ͼ��������
				//ǰ��
					0,one,one,one,0,0,one,0,
				//����
					one,one,one,0,0,one,0,0,
				//����
					one,one,one,0,0,one,0,0,
				//����
					one,one,one,0,0,one,0,0,
				//����
					one,0,0,0,one,one,0,one,
				//����
					0,0,0,one,one,0,one,one,
			};
			ByteBuffer tbb=ByteBuffer.allocateDirect(texCoords.length*4);
			tbb.order(ByteOrder.nativeOrder());//�����ֽ�˳��
			mTextureBuffer=tbb.asIntBuffer();//ת��Ϊint�ͻ���
			mTextureBuffer.put(texCoords);//�򻺳��з�����ͼ��������
			mTextureBuffer.position(0);//���û���������ʼλ��
			
	}
		public void draw(GL10 gl){
			gl.glVertexPointer(3, GL10.GL_FIXED, 0, mVertexBuffer);//Ϊ����ָ��������������
			//����FRONT��BACK������
			gl.glColor4f(1, 1, 1, 1);
			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);//����ͼ��	
			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 4, 4);//����ͼ��
			//����left��right������
			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 8, 4);//����ͼ��
			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 12, 4);//����ͼ��
			//����top��bottom������
			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 16, 4);//����ͼ��
			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 20, 4);//����ͼ��
		}
		/**    ����������ͼ     */
	public void loadTexture(GL10 gl, Context context, int resources) {
		// TODO Auto-generated method stub
		Bitmap bmp=BitmapFactory.decodeResource(context.getResources(), resources);//����λͼ
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D,0,bmp,0);//ʹ��ͼƬ��������
		bmp.recycle();//�ͷ���Դ
	}
}
