package TcpServer;

import java.awt.Frame;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class TcpServer  {
	public static void main(String[] args) {
		try {
			//�����󶨵��ض��˿ڵķ������׽��� ,�����Ŷ˿�666���ͻ�������
			ServerSocket serverSocket = new ServerSocket(666);
			//��ѭ����һֱ���з�����
			while (true) {
				System.out.println("����˿�ʼ��������");
				// accpt������������ֱ���пͻ�����֮��������
				Socket socket = serverSocket.accept();
				 //��Ϣ��ʾ��
                JOptionPane.showMessageDialog(null, "�������ӣ����ڴ�����Ϣ������ȷ����ť�鿴��");
				TcpServerThread serverThread = new TcpServerThread(socket);
				serverThread.run();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
