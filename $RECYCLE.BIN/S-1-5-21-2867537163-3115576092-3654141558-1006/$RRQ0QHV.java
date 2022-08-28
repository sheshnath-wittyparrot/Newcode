import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;



public class ClamAVMain {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		ClamAVMain clanav = new ClamAVMain();
		try {
			File file = new File("E:\\file_example_MP4_480_1_5MG.mp4");
			long length  = file.length();
			clanav.scanStream(new FileInputStream(file), length);
			
			//clanav.scanFileUsingClaimAVClient(new FileInputStream("E:\\123File.txt"));
		}  catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void scanStream(InputStream inputStream, long length) throws IOException, NoSuchAlgorithmException {
		 Socket socket = null;
		 OutputStream outStream = null;
		 InputStream inStream = null;
		 try {
		 socket = new Socket("13.67.239.152",3100);
		 outStream = new BufferedOutputStream(socket.getOutputStream());
		 socket.setSoTimeout(2000);
		 outStream.write("zINSTREAM\0".getBytes(StandardCharsets.UTF_8));
		 outStream.flush();
		 byte[] buffer = new byte[2048];
		 try {
		 inStream = socket.getInputStream();
		 int read = inputStream.read(buffer);
		 while (read >= 0) {
		 byte[] chunkSize = ByteBuffer.allocate(4).putInt(read).array();
		 outStream.write(chunkSize);
		 outStream.write(buffer, 0, read);
		 if (inStream.available() > 0) {
			 byte[] reply = new byte[(int)length];
			 DataInputStream dis = new DataInputStream(inStream);
			dis.readFully(reply);
		// byte[] reply = inStream.readAllBytes();
		 throw new IOException("Reply from server: " + new String(reply, StandardCharsets.UTF_8));
		 }
		 read = inputStream.read(buffer);
		 }
		 outStream.write(new byte[]{0,0,0,0});
		 outStream.flush();
		 String result = new BufferedReader(new InputStreamReader(inStream))
				   .lines().collect(Collectors.joining("\n"));
		 //System.out.println(new String(inStream.readAllBytes()));
		 System.out.println(result);
		 } finally { }
		 }finally {
		 try {
		 if(socket != null)
		 socket.close();
		 } catch (IOException e) {
		 System.out.println("Exception occurred while closing socket = {} "+ e.getMessage());
		 }
		 try {
		 if(inStream != null)
		 inStream.close();
		 } catch(IOException e) {
		 System.out.println("Exception occurred while closing input streams = {} "+ e.getMessage());
		 }
		 try {
		 if(outStream != null)
		 outStream.close();
		 } catch(IOException e) {
		 System.out.println("Exception occurred while closing output streams = {} "+ e.getMessage());
		 }
		 }
		}
}


