package TcpServer;

import java.awt.Frame;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class TcpServer  {
	public static void main(String[] args) {
		try {
			//创建绑定到特定端口的服务器套接字 ,即开放端口666给客户端请求
			ServerSocket serverSocket = new ServerSocket(666);
			//死循环，一直运行服务器
			while (true) {
				System.out.println("服务端开始接收数据");
				// accpt方法会阻塞，直到有客户端与之建立连接
				Socket socket = serverSocket.accept();
				 //消息提示框
                JOptionPane.showMessageDialog(null, "有人连接，正在传输消息，请点击确定按钮查看。");
				TcpServerThread serverThread = new TcpServerThread(socket);
				serverThread.run();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
