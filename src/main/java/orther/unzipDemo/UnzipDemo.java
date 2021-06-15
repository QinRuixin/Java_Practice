package orther.unzipDemo;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author qin
 * @description 解压 zip 包
 * @date 2021-06-15
 */
public class UnzipDemo {
    public static void main(String[] args) {

    }

    public static String saveFile(String rootPath, MultipartFile multipartFile, String fileName) throws IOException {
        System.out.println("enter save file. root path: " + rootPath + " filename: " + fileName + " upload filename: " + multipartFile.getOriginalFilename());
        File file = new File(rootPath + fileName);
        System.out.println("begin to transfer file from multipartFile to " + fileName);
        multipartFile.transferTo(file);
        return fileName;
    }

    public static String unZipAndSaveDir(String codePath, MultipartFile multipartFile) throws IOException {
        // 有重名的可能会出现 bug
        String fileName = multipartFile.getOriginalFilename();
        File file = new File(codePath + fileName);
        multipartFile.transferTo(file);
        unZip(codePath, codePath + fileName);
        return fileName.substring(0, fileName.length() - 4);
    }

    public static void unZip(String descDir, String zipPath) throws IOException {
        File fileZip = new File(zipPath);
        ZipFile zip = new ZipFile(fileZip);
//            ZipFile zip = new ZipFile(file, Charset.forName("GBK"));//解决中文文件夹乱码
        String name = zip.getName().substring(zip.getName().lastIndexOf(File.separatorChar) + 1, zip.getName().lastIndexOf('.'));

        File pathFile = new File(descDir + name);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }

        for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements(); ) {
            ZipEntry entry = entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
//            String outPath = (descDir + name + File.separatorChar + zipEntryName).replaceAll("\\*", "/");
            String outPath = (descDir + name + File.separatorChar + zipEntryName).replaceAll("/", Matcher.quoteReplacement(File.separator));

            // 判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf(File.separatorChar)));
            if (!file.exists()) {
                file.mkdirs();
            }
            // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if (new File(outPath).isDirectory()) {
                continue;
            }
            // 输出文件路径信息
//			System.out.println(outPath);

            FileOutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
        }
        System.out.println("******************解压完毕********************");
        return;
    }
}
