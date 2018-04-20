package util;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.Part;

public class FileHelper {

    private static final String SAVE_DIR = "uploadFiles";

    public static File SaveImage(Part imagem) throws IOException {
        // gets absolute path of the web application
        String appPath = System.getProperty("user.dir");

        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        String fileName = extractFileName(imagem);
        // refines the fileName in case it is an absolute path
        fileName = new File(fileName).getName();
        imagem.write(savePath + File.separator + fileName);
        return new File(savePath + File.separator + fileName);

    }

    private static String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

}
