package br.com.architecteam.algorithms.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class ReverseWordsInPhrase {

    private static final int MAX_LINE_SIZE = 80;

    public static void main(String[] args) throws IOException {
	Charset encoding = Charset.defaultCharset();
	InputStream in = new FileInputStream("/tmp/chalenge.txt");
	Reader reader = new InputStreamReader(in, encoding);

	Reader buffer = new BufferedReader(reader);

	OutputStream out = new FileOutputStream("/tmp/result.txt");
	Writer writer = new OutputStreamWriter(out);
	Writer buffWriter = new BufferedWriter(writer);

	int r;
	char[] orig = new char[MAX_LINE_SIZE];
	char[] dest = new char[MAX_LINE_SIZE];
	int j = 0;
	long start = System.currentTimeMillis();
	while (buffer.ready()) {
	    while ((r = buffer.read()) != -1 && ((char) r) != '\n') {
		orig[j++] = (char) r;
	    }
	    reverseWords(orig, dest, j);
	    buffWriter.write(dest, 0, j);
	    buffWriter.write('\n');
	    j = 0;
	}
	buffWriter.close();
	buffer.close();
	long end = System.currentTimeMillis();
	System.out.println("Execution time: " + (end - start) + "ms");
    }

    private static void reverseWords(char[] orig, char[] dest, int lenght) {
	int tokenReadPos = lenght - 1;
	int writePos = 0;

	while (tokenReadPos >= 0) {
	    if (orig[tokenReadPos] == ' ') {
		/* Write character */
		dest[writePos++] = orig[tokenReadPos--];
	    } else {
		/* Word characters */
		/* Store position of end of word */
		int wordEnd = tokenReadPos;
		/* Scan to next non-word character */
		while (tokenReadPos >= 0 && orig[tokenReadPos] != ' ')
		    tokenReadPos--;
		/* tokenReadPos went past the start of the word */
		int wordReadPos = tokenReadPos + 1;
		/* Copy the characters of the word */
		while (wordReadPos <= wordEnd) {
		    dest[writePos++] = orig[wordReadPos++];
		}
	    }
	}
    }

}
