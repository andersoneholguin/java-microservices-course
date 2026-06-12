public class RecursoDigital extends RecursoBibliografico {

    protected String format;
    protected String syllabus;

    public RecursoDigital(String title, String author, int publicationYear,
                          String format, String syllabus) {
        super(title, author, publicationYear);
        this.format = format;
        this.syllabus = syllabus;
    }

    public String getFormat() {
        return format;
    }

    public String getSyllabus() {
        return syllabus;
    }

    @Override
    public String getSummary() {
        return "Digital Resource: \"" + title + "\" by " + author +
               " (" + publicationYear + ") | Format: " + format +
               " | Syllabus: " + syllabus;
    }
}
