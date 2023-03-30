package SerializationDeserializaiton;

import java.io.*;

public class Serialization {
    private static Object Test1;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //serialization
        Test1 t1 = new Test1();
        FileOutputStream fos = new FileOutputStream("test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(t1);
        FileInputStream fis=new FileInputStream("test.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);

        Test1 t2=(Test1)ois.readObject();
        System.out.println(t1.i+" "+t2.j);

    }}
