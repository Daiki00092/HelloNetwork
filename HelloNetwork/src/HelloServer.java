import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {

	public static void main(String[] args)throws Exception {
		ServerSocket server = new ServerSocket(9000);
		Socket socket = server.accept();
		PrintWriter out = null;

		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		try {
			out = new PrintWriter(socket.getOutputStream());
			String line = br.readLine();
			System.out.println(line);

			String target = line.substring(5);

			out.print("HTTP/1.1 200 OK");
			out.print("\r\n");
			out.print("\r\n");
			if(target.startsWith("hello")){
				out.print("hello.");
			}else{
				out.print("bye");
			}
			out.flush();
		} finally {
			out.close();
			br.close();
			socket.close();
		}
//git
	}

}
