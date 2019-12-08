package com.ziki.server.mode;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.ziki.common.User;



public class Server {
	ServerSocket ss = null;
	Socket socket = null;
	public Server() {
		try {
			//等待客户端的连接
			System.out.println("..........");
			
			ss = new ServerSocket(5555);
			
			while(true) 
			{
				socket = ss.accept();
				
				// 接收客户端发来登录验证信息
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				User u = (User)ois.readObject();
				
				//在数据库对比-密码账户
				System.out.println("账号："+u.getUserId()+"密码："+u.getPassWord());
				//到道集合对比，此ID是否已经存在
				//cold..
				
				ClientBox.addClient(u.getUserId(), socket);
			}
			
			//判断用户的登录账号和密码
//			Message mess = new Message();
//			if (u.getUserId().equals("111")) {
//				if(u.getPassWord().equals("111")) {
//					// 1 登陆成功
//					mess.setMessType("1");
//				}				
//			}else {
//				// 2 代表登录失败
//				mess.setMessType("2");
//			}
//			
//			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
//			oos.writeObject(mess);
//			
//			System.out.println("ok");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		Server an = new Server();
	}
	
}
