import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Socket socket;
        Scanner scan = new Scanner(System.in);
        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;
        socket = new Socket(InetAddress.getByName("127.0.0.1"),23444);

        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        System.out.println("Hello my server: ");

        String msgToServer = scan.nextLine();

        dataOutputStream.writeUTF(msgToServer);
        dataOutputStream.flush();

        String msgFromServer = dataInputStream.readUTF();
        System.out.println("Hello server" + msgFromServer);

        socket.close();

    }
}
