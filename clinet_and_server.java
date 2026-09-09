
package com.mycompany.server;// এই লাইনে package-এর নাম দেওয়া হয়েছে // Client class এই package-এর ভিতরে থাকবে
import java.io.*; // java.io package থেকে input/output সম্পর্কিত সব class import করা হয়েছে
import java.net.*; // java.net package থেকে networking সম্পর্কিত class import করা হয়েছে
public class Client { // Client নামে একটি class তৈরি করা হয়েছে
    public static void main(String[] args) { // Program-এর execution এখান থেকে শুরু হবে
        try {
            // localhost = একই computer-এর Server // 6000 = Server-এর port number // Client Server-এর সাথে connection তৈরি করছে
            Socket s = new Socket("localhost", 6000);

            // Server থেকে data receive করার জন্য InputStream তৈরি করা হয়েছে
            DataInputStream din = new DataInputStream(s.getInputStream());

            // Server-এর কাছে data send করার জন্য OutputStream তৈরি করা হয়েছে
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // Keyboard থেকে input নেওয়ার জন্য BufferedReader তৈরি করা হয়েছে
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

            // str = Client-এর message রাখবে// str2 = Server থেকে পাওয়া reply রাখবে
            String str = "", str2 = "";

            // যতক্ষণ Client-এর message "exit" না হবে,// ততক্ষণ loop চলতে থাকবে
            while (!str.equals("exit")) {

                // Keyboard থেকে Client-এর message নেওয়া হচ্ছে
                str = br.readLine();

                // Client-এর message Server-এর কাছে পাঠানো হচ্ছে // writeUTF() String data পাঠায়
                dout.writeUTF(str);

                // পাঠানো data নিশ্চিতভাবে send করার জন্য flush()
                dout.flush();

                // Server-এর কাছ থেকে reply গ্রহণ করা হচ্ছে // readUTF() String data receive করে
                str2 = (String) din.readUTF();

                // Server-এর reply screen-এ দেখানো হচ্ছে
                System.out.println("Server Says: " + str2);
            }
            // DataOutputStream বন্ধ করা হচ্ছে
            dout.close();

            // Socket connection বন্ধ করা হচ্ছে
            s.close();

        } catch (Exception e) { // কোনো error হলে error message দেখাবে
            System.out.println(e);
        };

    }
}

//__________________________________________________________________________________

package com.mycompany.server; // এই লাইনে package-এর নাম দেওয়া হয়েছে // Server class এই package-এর ভিতরে থাকবে
import java.io.*; // Input/Output সম্পর্কিত সব class import করা হয়েছে
import java.net.*; // Networking সম্পর্কিত class যেমন ServerSocket, Socket import করা হয়েছে
public class Server { // Server নামে একটি class তৈরি করা হয়েছে
    public static void main(String[] args) { // Program-এর execution এখান থেকে শুরু হবে
        try {
            // ServerSocket তৈরি করা হচ্ছে // 6000 হলো Server-এর port number // Server এই port-এ Client-এর জন্য অপেক্ষা করবে
            ServerSocket ss = new ServerSocket(6000);

            // Server চালু হয়েছে এবং Client-এর জন্য অপেক্ষা করছে
            System.out.println("waiting for client....");

            // Client-এর connection-এর জন্য অপেক্ষা করছে
            // Client connect করলে Socket object return করবে
            Socket s = ss.accept();

            // Client থেকে data receive করার জন্য
            // DataInputStream তৈরি করা হয়েছে
            DataInputStream din = new DataInputStream(s.getInputStream());

            // Client-এর কাছে data send করার জন্য
            // DataOutputStream তৈরি করা হয়েছে
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // Server-এর keyboard থেকে input নেওয়ার জন্য
            // BufferedReader তৈরি করা হয়েছে
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // str = Client-এর message রাখবে
            // str2 = Server-এর reply রাখবে
            String str = "", str2 = "";

            // str-এর মধ্যে "exit" না আসা পর্যন্ত
            // loop চলতে থাকবে
            while (!str.equals("exit")) {

                // Client-এর কাছ থেকে message receive করা হচ্ছে
                // readUTF() একটি String receive করে
                str = (String) din.readUTF();

                // Client-এর পাঠানো message screen-এ দেখানো হচ্ছে
                System.out.println("Client Says: " + str);

                // Server-এর keyboard থেকে reply নেওয়া হচ্ছে
                str2 = br.readLine();

                // Server-এর reply Client-এর কাছে পাঠানো হচ্ছে
                dout.writeUTF(str2);

                // Data নিশ্চিতভাবে পাঠানোর জন্য flush() করা হচ্ছে
                dout.flush();
            }

            // Client থেকে data নেওয়ার stream বন্ধ করা হচ্ছে
            din.close();

            // Client-এ data পাঠানোর stream বন্ধ করা হচ্ছে
            dout.close();

            // ServerSocket বন্ধ করা হচ্ছে
            ss.close();

        } catch (Exception e) {

            // কোনো error হলে error message দেখাবে
            System.out.println(e);
        };
    }
}






