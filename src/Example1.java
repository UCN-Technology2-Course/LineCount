import java.io.*;

public class Example1 {

	public int lineCount(String path) throws IOException {

		FileInputStream fis = new FileInputStream(path);

		int cnt = 0;
		int b;

		while ((b = fis.read()) != -1) {
			if (b == '\n')
				cnt++;
		}

		fis.close();
		return cnt;
	}
}