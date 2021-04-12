import java.io.*;

public class Example2 {

	public int lineCount(String path) throws IOException {

		FileInputStream fis = new FileInputStream(path);

		BufferedInputStream bis = new BufferedInputStream(fis);

		int cnt = 0;
		int b;

		while ((b = bis.read()) != -1) {
			if (b == '\n')
				cnt++;
		}

		bis.close();
		return cnt;

	}
}