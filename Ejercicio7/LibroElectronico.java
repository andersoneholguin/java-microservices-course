public class LibroElectronico extends RecursoDigital {

    private int numberOfPages;
    private boolean hasDRM;

    public LibroElectronico(
        String title, 
        String author, 
        int publicationYear,
        String format, 
        String syllabus,
        int numberOfPages, 
        boolean hasDRM) {
        
        super(title, author, publicationYear, format, syllabus);
        this.numberOfPages = numberOfPages;
        this.hasDRM = hasDRM;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public boolean hasDRM() {
        return hasDRM;
    }

    @Override
    public String getSummary() {
        return "E-Book: \"" + title + "\" by " + author +
               " (" + publicationYear + ") | Format: " + format +
               " | Syllabus: " + syllabus +
               " | Pages: " + numberOfPages +
               " | DRM Protected: " + (hasDRM ? "Yes" : "No");
    }
}
