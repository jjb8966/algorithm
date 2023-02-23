package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_20291 {

    private static int numberOfFiles;
    private static NotebookFile[] files;

    private static class NotebookFile implements Comparable<NotebookFile>{
        String fileName;
        String fileExtension;

        public NotebookFile(String fileName) {
            this.fileName = fileName;
            this.fileExtension = fileName.split("\\.")[1];      // .은 '\\'을 앞에 붙여야 인식함. [.]도 가능
        }

        @Override
        public int compareTo(NotebookFile o) {
            return this.fileExtension.compareTo(o.fileExtension);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfFiles = Integer.parseInt(br.readLine());
        
        files = new NotebookFile[numberOfFiles];
        
        for (int i = 0; i < numberOfFiles; i++) {
            files[i] = new NotebookFile(br.readLine());
        }
    }

    private static void process() {
        Arrays.sort(files);

        String currentExtension = files[0].fileExtension;
        int numberOfExtension = 0;

        for (int i = 0; i < files.length; i++) {        // 2번째 파일부터 시작
            if(currentExtension.equals(files[i].fileExtension)) {
                numberOfExtension++;
            } else {
                System.out.println(currentExtension + " " + numberOfExtension);
                currentExtension = files[i].fileExtension;
                numberOfExtension = 1;
            }
        }

        System.out.println(currentExtension + " " + numberOfExtension);     // 마지막 확장자는 초기화된 후 출력되지 않기 때문에 추가로 작성
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
