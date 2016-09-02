package com.lia.Array;

/**
 * The API: int read4(char[] buf) reads 4 characters at a time from a file. char[] buf is destination buffer
 * The return value is the actual number of characters read.
 * For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char[] buf, int n) that reads n characters from the file.
 *
 * Note: The read function will only be called once for each test case.
 * Created by liqu on 8/31/16.
 */
public class ReadNCharsGivenRead4_157 {
    /*
    When read4 returns less than 4, we know it must reached the end of file.
    However, take note that read4 returnning 4 could mean the last 4 bytes of the file.
    To make sure that the buffer is not copied more than n bytes, copy the remaining bytes (n - readBytes)
    or the number of bytes read, whichever is smaller
     */

    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int readBytes = 0;
        boolean eof = false;
        while (!eof && readBytes < n) {
            int size = read4(buffer);
            if (size < 4) eof = true;
            int bytes = Math.min(size, n - readBytes);
            System.arraycopy(buffer, 0, buf, readBytes, bytes);
            readBytes += bytes;
        }
        return readBytes;
    }

    private int read4(char[] buf) {
        return (int) (Math.random() * 4);
    }
}
