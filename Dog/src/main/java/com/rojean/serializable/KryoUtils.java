package com.rojean.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;

public class KryoUtils {

	public static Kryo kryo;
	
	static {
		 System.out.println("ini");
		 kryo = new Kryo();
	    // kryo.setReferences(true);
	    // kryo.register(new Object().getClass(), new JavaSerializer());
		
	}
	
	
	public static byte[] kryoSerializable(Object obj) {
		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
	     Output output = new Output(baos);
	     kryo.writeClassAndObject(output, obj);
	     output.close();
	    return baos.toByteArray();
	}
	
	
	public static Object kryoDeSerializable(byte[] bt) throws IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(bt);
		Input input = new Input(bais);
		bais.close();
		input.close();
		return kryo.readClassAndObject(input);
		
	}
}
