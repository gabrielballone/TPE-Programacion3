import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        Genre policial = new Genre("policial");
        Genre arte = new Genre("arte");
        Genre ciencia = new Genre("ciencia");
        HashSet<Genre> GenresSet = new HashSet<Genre>();
        GenresSet.add(policial);
        GenresSet.add(arte);
        GenresSet.add(ciencia);

        Book book1 = new Book("Una muerte!");
        book1.addGenre(policial);
        
        System.out.println(GenresSet);
        System.out.println(book1);
    }
}
