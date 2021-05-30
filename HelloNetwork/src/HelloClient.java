import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HelloClient {

	public static void main(String[] args)throws Exception {

		Socket server = new Socket("127.0.0.1",9000);

		PrintWriter out = new PrintWriter(server.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = null;

		while((line = br.readLine()) != null ) {
			out.println(line);
			out.flush();

			if(line.equals("bye")) {
				break;
			}
		}
		br.close();
		server.close();
	}
}
