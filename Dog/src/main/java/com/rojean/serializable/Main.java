package com.rojean.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import com.rojean.bean.Order;
import com.rojean.bean.OrderInfo;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		List<Order> lst = new ArrayList<Order>();
		for(int i=0;i<6;i++) {
			Order order = new Order();
			order.setCode("code-01");
			List<OrderInfo> infos = new ArrayList<OrderInfo>();
			OrderInfo info = new OrderInfo();
			info.setName("¹Ï¹Ï");
			info.setPrice(5.0);
			infos.add(info);
			order.setOrderInfos(infos);
			
			lst.add(order);
		}
		
//		System.out.println("java begin");
//		long f1 = System.currentTimeMillis();
//		for(Order v :lst) {
//			byte[] bt = new Main().javaSerializable(v);
//			// Order newOrd = (Order) new Main().javaUnSerializable(bt);
//			//System.out.println(newOrd.getOrderInfos().get(0).getName());
//		}
//		System.out.println("java Cost: " + (System.currentTimeMillis() - f1));
		
		
	
		System.out.println("kryo begin");
		long f1 = System.currentTimeMillis();
		Order v = lst.get(0);
		byte[] bt = KryoUtils.kryoSerializable(v);
		System.out.println("#");
		Order o = (Order) new Main().javaUnSerializable(bt);
		System.out.println("Kryo Cost: " + (System.currentTimeMillis() - f1));
		
		System.out.println("###" + o.getCode() + o.getOrderInfos().get(0).getName());
		
	}

	private byte[] javaSerializable(Object obj) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos =  new ObjectOutputStream(baos);
		oos.writeObject(obj);
		return baos.toByteArray();
	}
	
	private Object javaUnSerializable(byte[] byteArr) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bais = new ByteArrayInputStream(byteArr);
		ObjectInputStream ois = new ObjectInputStream(bais);
		return ois.readObject();
	}
	
	
	private byte[] kryoSerializable(Object obj,Kryo kryo) {
		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
	     Output output = new Output(baos);
	     kryo.writeClassAndObject(output, obj);
	     output.flush();
	     output.close();
	    return baos.toByteArray();
	}

}
