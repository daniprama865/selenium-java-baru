package qa.framework.tests;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class AssertLesson {

    public static void main (String[] args) {

        // int a = 5;
        // int b = 10;
        // int c = a + b;

        List<String> namaSiswa = new ArrayList<>();
        namaSiswa.add("Harrin");
        namaSiswa.add("Bayu");

        // System.out.println(namaSiswa.size());

        for ( int i = 0; i < namaSiswa.size(); i++) {
            String nama = namaSiswa.get(i);

            System.out.println(nama);

            // if ( nama.equals("Harrin")) {
            //     System.out.println("Nama Harrin ditemukan");
            // } else {
            //     System.out.println("Nama Harrin tidak ditemukan");

            // }

        }

        
        

        

        
        
    }

}
