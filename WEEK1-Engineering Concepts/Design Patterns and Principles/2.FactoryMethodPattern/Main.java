// Main.java
public class Main {
    public static void main(String[] args) {
        DocFactory wordFactory = new WordDocFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        DocFactory pdfFactory = new PdfDocFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        DocFactory excelFactory = new ExcelDocFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}
