package com.lia.Array;

/**
 * Similar to Q157, but the read function may be called multiple times.
 *
 * Solution:
 * This makes the problem a lot more complicated, because it can be called multiple times and involves storing states.
 *
 * Therefore, we design the following class member variables to store the states:
 * i.   buffer - An array of size 4 use to store data returned by read 4 temporarily.
 *      If the characters were read into the buffer and were not used partially, they will be used in the next call.
 * ii.  offset - Use to keep track of the offset index where the data begins in the next read call.
 *      The buffer could be read partially (due to constraints of reading up to n bytes) and therefore leaving some
 *      data behind.
 * iii. bufsize - The real buffer size that stores the actual data. If bufsize > 0, that means there is partial data
 *      left in buffer from the last read call and we should consume it before calling read4 again. On the other hand,
 *      if bufsize == 0, it means there is no data left in buffer.
 *
 * Created by liqu on 8/31/16.
 */
public class ReadNCharsGivenRead4_158 {
    private char[] buffer = new char[4];
    private int offset = 0, bufsize = 0;

    public int read(char[] buf, int n) {
        int readBytes = 0;
        boolean eof = false;

        while (!eof && readBytes < n) {
            if (bufsize == 0) {
                bufsize = read4(buffer);
                eof = bufsize < 4;
            }
            int bytes = Math.min(bufsize, n - readBytes);
            System.arraycopy(buffer, offset, buf, readBytes, bytes);
            offset = (offset + bytes) % 4;
            bufsize -= bytes;
            readBytes += bytes;
        }
        return readBytes;
    }


    private int read4(char[] buf) {
        return (int) (Math.random() * 4);
    }
}
