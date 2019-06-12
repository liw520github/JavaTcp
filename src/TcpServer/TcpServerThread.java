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
	//初始化
	public TcpServerThread(Socket socket){
		this.socket =socket;
	}
	@Override
	public void run() {
		InputStreamReader reader =null;
		BufferedReader bufferedReader =null;
		OutputStream outputStream =null;
		try {
			//防止中文字符传输乱码加上socket.getInputStream(), "UTF-8"
			reader =new InputStreamReader(socket.getInputStream(), "UTF-8");
			bufferedReader =new BufferedReader(reader);
			String s = null;
			StringBuffer sbBuffer =new StringBuffer();
			while((s =bufferedReader.readLine())!=null){
				sbBuffer.append(s);
			}
			//弹出对话框接收客户端反馈回来的消息
			 JOptionPane.showMessageDialog(null, "服务器收到客户端传来的数据为："+sbBuffer.toString());
		//关闭输入流
//			socket.shutdownInput();
		
//		返回给客户端的数据
		outputStream =socket.getOutputStream();
		outputStream.write(("从服务器接收到的数据：------"+sbBuffer.toString()).getBytes(Charset.forName("UTF-8")));
		outputStream.flush();
//		socket.shutdownOutput();
		socket.close();
		//关闭io
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
