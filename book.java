package Library;

import java.util.ArrayList;

public class book {
    private String bName;
    private int bPageNum;
    private String bType;
    private String bAuthor;
    private double bStar;

    static ArrayList<book> bList = new ArrayList<>();
    public String getbName() {
        return bName;
    }

    public int getbPageNum() {
        return bPageNum;
    }

    public String getbType() {
        return bType;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public double getbStar() {
        return bStar;
    }

    public book(String bName, int bPageNum, String bType, String bAuthor) {
        this.bName = bName;
        this.bPageNum = bPageNum;
        this.bType = bType;
        this.bAuthor = bAuthor;

    }
    public book(){getbList();}

    public void addBook(){
        for (book b:bList){
            if (b.equals(bName)){
                bList.add(b);
                System.out.println(b.bName + " is added your list");
            }
        }
    }
    public void getbList(){
        book b = new book("1984",560,"War","George Orwell");
        book b2 = new book("Dönüşüm",150,"Story","Franz Kafka");
        book b3 = new book("Satranç",260,"Story","Franz Kafka");
        book b4 = new book("Hayvan Çiftliği",60,"Friend","Alperen Alegöz");
        book b5 = new book("Kürk Mantolu Madonna",360,"Adventure","Leonardo Da Vinci");

        bList.add(b);
        bList.add(b2);
        bList.add(b3);
        bList.add(b4);
        bList.add(b5);
    }
    public static void getList(){
        for (int i=0;i< bList.size();i++){
            System.out.println(bList.get(i).getbName());
        }
    }


}
