import java.io.*;

public class Example4 {

	public int lineCount(String path) throws IOException {

		int len = (int) (new File(path).length());

		FileInputStream fis = new FileInputStream(path);

		byte buf[] = new byte[len];

		fis.read(buf);
		fis.close();

		int cnt = 0;

		for (int i = 0; i < len; i++) {
			if (buf[i] == '\n')
				cnt++;
		}

		return cnt;
	}
}