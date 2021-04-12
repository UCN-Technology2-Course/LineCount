import java.io.*;

public class Example3 {

	public int lineCount(String path) throws IOException {

		FileInputStream fis = new FileInputStream(path);

		byte buf[] = new byte[2048];
		int cnt = 0;
		int n;

		while ((n = fis.read(buf)) != -1) {
			for (int i = 0; i < n; i++) {
				if (buf[i] == '\n')
					cnt++;
			}
		}

		fis.close();
		return cnt;
	}
}