package TcpServer;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;

import javax.swing.JOptionPane;

public class TcpServerThread implements Runnable {
	private Socket socket;
	//��ʼ��
	public TcpServerThread(Socket socket){
		this.socket =socket;
	}
	@Override
	public void run() {
		InputStreamReader reader =null;
		BufferedReader bufferedReader =null;
		OutputStream outputStream =null;
		try {
			//��ֹ�����ַ������������socket.getInputStream(), "UTF-8"
			reader =new InputStreamReader(socket.getInputStream(), "UTF-8");
			bufferedReader =new BufferedReader(reader);
			String s = null;
			StringBuffer sbBuffer =new StringBuffer();
			while((s =bufferedReader.readLine())!=null){
				sbBuffer.append(s);
			}
			//�����Ի�����տͻ��˷�����������Ϣ
			 JOptionPane.showMessageDialog(null, "�������յ��ͻ��˴���������Ϊ��"+sbBuffer.toString());
		//�ر�������
//			socket.shutdownInput();
		
//		���ظ��ͻ��˵�����
		outputStream =socket.getOutputStream();
		outputStream.write(("�ӷ��������յ������ݣ�------"+sbBuffer.toString()).getBytes(Charset.forName("UTF-8")));
		outputStream.flush();
//		socket.shutdownOutput();
		socket.close();
		//�ر�io
		if (reader!=null) {
			reader.close();
		}
		if (bufferedReader!=null) {
			bufferedReader.close();
		}
		if (outputStream!=null) {
			outputStream.close();
		}
	
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}
	
}
