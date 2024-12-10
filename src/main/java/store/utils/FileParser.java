package store.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    private static final String DELIMITER = ",";

    private FileParser() {
    }

    public static FileParser create() {
        return new FileParser();
    }

    public static List<String> parseDelimiter(String readLine) {
        return List.of(readLine.split(DELIMITER));
    }

    public static List<String> readFile(String directory)   {
        List<String> line = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(directory));
            readLinesFromFile(br, line);
        } catch (IOException e) {
            throw new IllegalArgumentException("잘못된 파일 형식입니다. 파일을 확인해주세요.");
        }
        return line;
    }

    private static void readLinesFromFile(BufferedReader br, List<String> lines) throws IOException {
        br.readLine(); // 첫줄 스킵
        String line;
        while((line = br.readLine()) != null) {
            lines.add(line);
        }
    }

}
