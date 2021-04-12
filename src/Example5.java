import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class Example5 {

	public void readFile(String path) throws IOException {
		
		AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(Path.of(path), StandardOpenOption.READ);

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		long position = 0;

		Future<Integer> operation = fileChannel.read(buffer, position);

		while (!operation.isDone())
			; // BUSY WAIT, yuk!

		buffer.flip();
		byte[] data = new byte[buffer.limit()];
		buffer.get(data);
		System.out.println(new String(data));
		buffer.clear();
	}
}