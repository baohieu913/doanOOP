package com.example.librarian.Admin;

public class Author {
    private String codeAuthor;
    private String nameAuthor;
    private String birthOfYear;
    private String deathOfYear;
    private String bioAuthor;

    public Author() {
    }

    public Author(String codeAuthor, String nameAuthor, String birthOfYear, String deathOfYear, String bioAuthor) {
        this.codeAuthor = codeAuthor;
        this.nameAuthor = nameAuthor;
        this.birthOfYear = birthOfYear;
        this.deathOfYear = deathOfYear;
        this.bioAuthor = bioAuthor;
    }

    public String getCodeAuthor() {
        return codeAuthor;
    }

    public void setCodeAuthor(String codeAuthor) {
        this.codeAuthor = codeAuthor;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getBirthOfYear() {
        return birthOfYear;
    }

    public void setBirthOfYear(String birthOfYear) {
        this.birthOfYear = birthOfYear;
    }

    public String getDeathOfYear() {
        return deathOfYear;
    }

    public void setDeathOfYear(String deathOfYear) {
        this.deathOfYear = deathOfYear;
    }

    public String getBioAuthor() {
        return bioAuthor;
    }

    public void setBioAuthor(String bioAuthor) {
        this.bioAuthor = bioAuthor;
    }
}
