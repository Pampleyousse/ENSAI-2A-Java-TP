package fr.ensai.library;

public class Item {
    // Attributes
    private String title;
    private int year;
    private int pageCount;

    public Item(String title, int year, int pageCount) {
        this.title = title;
        this.year = year;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
