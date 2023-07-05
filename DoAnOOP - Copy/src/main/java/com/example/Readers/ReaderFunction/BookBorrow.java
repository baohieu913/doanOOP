package com.example.Readers.ReaderFunction;

public class BookBorrow {
    private String nameBookBorrow;
    private String codeBookBorrow;
    private String quantityBookBorrow;

    public BookBorrow() {
    }

    public BookBorrow(String nameBookBorrow, String codeBookBorrow, String quantityBookBorrow) {
        this.nameBookBorrow = nameBookBorrow;
        this.codeBookBorrow = codeBookBorrow;
        this.quantityBookBorrow = quantityBookBorrow;
    }

    public String getNameBookBorrow() {
        return nameBookBorrow;
    }

    public void setNameBookBorrow(String nameBookBorrow) {
        this.nameBookBorrow = nameBookBorrow;
    }

    public String getCodeBookBorrow() {
        return codeBookBorrow;
    }

    public void setCodeBookBorrow(String codeBookBorrow) {
        this.codeBookBorrow = codeBookBorrow;
    }

    public String getQuantityBookBorrow() {
        return quantityBookBorrow;
    }

    public void setQuantityBookBorrow(String quantityBookBorrow) {
        this.quantityBookBorrow = quantityBookBorrow;
    }
}
