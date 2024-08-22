package org.cis1200;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.io.BufferedReader;

/**
 * FileLineIterator provides a useful wrapper around Java's provided
 * BufferedReader and provides practice with implementing an Iterator. Your
 * solution should not read the entire file into memory at once, instead reading
 * a line whenever the next() method is called.
 * <p>
 * Note: Any IOExceptions thrown by readers should be caught and handled
 * properly. Do not use the ready() method from BufferedReader.
 */
public class FileLineIterator implements Iterator<String> {

    // Add the fields needed to implement your FileLineIterator
    private final BufferedReader reader;
    private String c;

    /**
     * Creates a FileLineIterator for the reader. Fill out the constructor so
     * that a user can instantiate a FileLineIterator. Feel free to create and
     * instantiate any variables that your implementation requires here. See
     * recitation and lecture notes for guidance.
     * <p>
     * If an IOException is thrown by the BufferedReader, then hasNext should
     * return false.
     * <p>
     * The only method that should be called on BufferedReader is readLine() and
     * close(). You cannot call any other methods.
     *
     * @param reader - A reader to be turned to an Iterator
     * @throws IllegalArgumentException if reader is null
     */
    public FileLineIterator(BufferedReader reader) {
        if (reader == null) {
            throw new IllegalArgumentException();
        }
        this.reader = reader;
        try {
            this.c = reader.readLine();

        } catch (java.io.IOException e) {
            c = null;
        }

    }

    /**
     * Creates a FileLineIterator from a provided filePath by creating a
     * FileReader and BufferedReader for the file.
     * <p>
     * DO NOT MODIFY THIS METHOD.
     * 
     * @param filePath - a string representing the file
     * @throws IllegalArgumentException if filePath is null or if the file
     *                                  doesn't exist
     */
    public FileLineIterator(String filePath) {
        this(fileToReader(filePath));
    }

    /**
     * Takes in a filename and creates a BufferedReader.
     * See Java's documentation for BufferedReader to learn how to construct one
     * given a path to a file.
     *
     * @param filePath - the path to the CSV file to be turned to a
     *                 BufferedReader
     * @return a BufferedReader of the provided file contents
     * @throws IllegalArgumentException if filePath is null or if the file
     *                                  doesn't exist
     */
    public static BufferedReader fileToReader(String filePath) {
        BufferedReader br;
        try {
            java.io.FileReader reader = new java.io.FileReader(filePath);
            br = new BufferedReader(reader);
        } catch (FileNotFoundException | NullPointerException e) {
            throw new IllegalArgumentException();
        }
        return br;
    }

    /**
     * Returns true if there are lines left to read in the file, and false
     * otherwise.
     * <p>
     * If there are no more lines left, this method attempts to close the
     * BufferedReader. In case of an IOException during the closing process,
     * an error message is printed to the console indicating the issue.
     *
     * @return a boolean indicating whether the FileLineIterator can produce
     *         another line from the file
     */
    @Override
    public boolean hasNext() {
        if (c == null) {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException("File Could Not Be Closed.");
            }
        }
        return !(c == null);
    }

    /**
     * Returns the next line from the file, or throws a NoSuchElementException
     * if there are no more strings left to return (i.e. hasNext() is false).
     * <p>
     * This method also advances the iterator in preparation for another
     * invocation. If an IOException is thrown during a next() call, your
     * iterator should make note of this such that future calls of hasNext()
     * will return false and future calls of next() will throw a
     * NoSuchElementException
     *
     * @return the next line in the file
     * @throws java.util.NoSuchElementException if there is no more data in the
     *                                          file
     */
    @Override
    public String next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        String ans = "";
        try {
            ans = c;
            c = reader.readLine();
        } catch (IOException e) {
            c = null;
        }
        return ans;
    }
}
