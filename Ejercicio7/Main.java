import java.util.ArrayList;
import java.util.List;

public class Main {

    public static LibroElectronico findOldestEBook(List<RecursoBibliografico> collection) {
        LibroElectronico oldest = null;

        for (RecursoBibliografico resource : collection) {
            if (resource instanceof LibroElectronico) {
                LibroElectronico ebook = (LibroElectronico) resource;
                if (oldest == null || ebook.getPublicationYear() < oldest.getPublicationYear()) {
                    oldest = ebook;
                }
            }
        }

        return oldest;
    }

    public static void main(String[] args) {

        // --- Fleet: mixed collection of digital resources ---
        List<RecursoBibliografico> library = new ArrayList<>();

        library.add(new RecursoDigital(
                "Introduction to Algorithms",
                "Cormen et al.",
                2009,
                "PDF",
                "Sorting, Graphs, Dynamic Programming"));

        library.add(new RecursoDigital(
                "Clean Code",
                "Robert C. Martin",
                2008,
                "EPUB",
                "Best practices, Refactoring, Testing"));

        library.add(new LibroElectronico(
                "The Pragmatic Programmer",
                "Hunt & Thomas",
                1999,
                "MOBI",
                "Software Craftsmanship",
                352,
                false));

        library.add(new LibroElectronico(
                "Design Patterns",
                "Gang of Four",
                1994,
                "PDF",
                "Creational, Structural, Behavioral Patterns",
                395,
                true));

        library.add(new LibroElectronico(
                "Effective Java",
                "Joshua Bloch",
                2018,
                "EPUB",
                "Java Best Practices",
                412,
                true));

        System.out.println("===== Library Collection =====");
        for (RecursoBibliografico resource : library) {
            System.out.println(resource.getSummary());
        }

        System.out.println("\n===== Oldest E-Book =====");
        LibroElectronico oldest = findOldestEBook(library);
        if (oldest != null) {
            System.out.println("Found: " + oldest.getSummary());
        } else {
            System.out.println("No e-books found in the collection.");
        }
    }
}
