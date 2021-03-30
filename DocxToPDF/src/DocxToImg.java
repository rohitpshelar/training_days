
import com.aspose.words.Document;
import com.aspose.words.ImageSaveOptions;
import com.aspose.words.PageSet;
import com.aspose.words.SaveFormat;

/**
 * Created by white
 */
public class DocxToImg {

    public static void main(String args[]) throws Exception {


        new DocxToImg().generateImages(System.getProperty("user.dir") +"\\All file types\\v1.docx");

    }

    public void generateImages(final String sourcePath) {
        try {
            Document doc = new Document(sourcePath);
            ImageSaveOptions options = new ImageSaveOptions(SaveFormat.JPEG);
            options.setJpegQuality(100);
            options.setResolution(100);
            //options.setUseHighQualityRendering(true);
            for (int i = 0; i < doc.getPageCount(); i++) {
                String imageFilePath = System.getProperty("user.dir") +"\\All file types\\" + "output_" + i + ".jpg";
                options.setPageSet(new PageSet(i));
               // options.setPageIndex(i);
                doc.save(imageFilePath, options);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}