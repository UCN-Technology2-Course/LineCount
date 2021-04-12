import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class Example6 {

	private static Thread currentThread = Thread.currentThread();

	public void readFile(String path) throws IOException {

		AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(Path.of(path));

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		long position = 0;

		fileChannel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {

			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				System.out.println(attachment + " completed and " + result + " bytes are read. ");
				currentThread.interrupt();
			}

			@Override
			public void failed(Throwable e, ByteBuffer attachment) {
				System.out.println(attachment + " failed with exception:");
				e.printStackTrace();
				currentThread.interrupt();
			}
		});

		try {

			currentThread.join();

		} catch (InterruptedException e) {

		}

		buffer.flip();

		System.out.print("Buffer contents: ");

		while (buffer.hasRemaining()) {

			System.out.print((char) buffer.get());
		}
		System.out.println(" ");

		buffer.clear();
		fileChannel.close();
	}
}