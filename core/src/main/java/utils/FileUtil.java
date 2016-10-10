package utils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.util.List;

/**
 * Created with by shuangyao on 2016/10/10.
 */
public class FileUtil {

    private static final Logger logger = Logger.getLogger(FileUtil.class);

    /**
     * Append info to the end of the specified file.
     * @param filePath
     * @param info
     * @return
     */
    public static boolean appendFile(String filePath, String info) {
        if (StringUtils.isBlank(info)) {
            return true;
        }

        File file = validFile(filePath);
        if (file == null) {
            logger.debug("Invalid file." + "\"" + filePath + "\"");
            return false;
        }

        boolean result = true;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(info + "\r\n");
            writer.flush();
        } catch (Exception e) {
            logger.error(e.getMessage());
            result = false;
        } finally {
            IOUtils.closeQuietly(writer);
            return result;
        }
    }

    public static List<String> readFile(String filePath,
                                        int startLine,
                                        int endLine,
                                        boolean excludsNullLine) {
        File file = validFile(filePath);
        if (file == null) {
            logger.debug("Invalid file." + "\"" + filePath + "\"");
            return null;
        }
        if (startLine <0 || endLine < startLine
                || startLine > getFileLineNumber(filePath)) {
            logger.debug("Invalid line number." +
                    "\"startLine : " + startLine + "\"" + ", " +
                    "\"endLine : " + endLine + "\"");
            return null;
        }

        LineNumberReader reader = null;
        List<String> result = null;
        try {
            reader = new LineNumberReader(new FileReader(file));
            String line ;
            while ((line = reader.readLine()) != null) {
                if (reader.getLineNumber() < startLine) {
                    continue;
                }
                if (reader.getLineNumber() > endLine) {
                    break;
                }

                if (excludsNullLine && StringUtils.isBlank(line)) {
                    continue;
                }
                result.add(line);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            result = null;
        } finally {
            IOUtils.closeQuietly(reader);
            return result;
        }

    }

    public static int getFileLineNumber(String filePath) {
        File file = validFile(filePath);
        if (file == null) {
            return -1;
        }

        LineNumberReader reader = null;
        int lineNumber = -1;
        try {
            reader = new LineNumberReader(new FileReader(file));
            reader.skip(Long.MAX_VALUE);
            lineNumber = reader.getLineNumber();
            lineNumber++;
        } catch (Exception e) {
            logger.error(e.getMessage());
            lineNumber =  -1;
        } finally {
            IOUtils.closeQuietly(reader);
            return lineNumber;
        }
    }

    private static File validFile(String filePath) {
        if (StringUtils.isBlank(filePath)) {
            logger.debug("File path cannot be null.");
            return null;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            logger.debug("File does not exist.");
            return null;
        }
        if (file.isDirectory()) {
            logger.debug("This is a directory.");
            return null;
        }
        return file;
    }
}
