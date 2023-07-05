package com.example.librarian.Admin;

public class Publisher {
    private String codePublish;
    private String namePublish;
    private String addressPublish;
    private String emailPublish;
    private String phonePublish;
    private String representPublish;

    public Publisher() {
    }

    public Publisher(String codePublish, String namePublish, String addressPublish, String emailPublish, String phonePublish, String representPublish) {
        this.codePublish = codePublish;
        this.namePublish = namePublish;
        this.addressPublish = addressPublish;
        this.emailPublish = emailPublish;
        this.phonePublish = phonePublish;
        this.representPublish = representPublish;
    }

    public String getCodePublish() {
        return codePublish;
    }

    public void setCodePublish(String codePublish) {
        this.codePublish = codePublish;
    }

    public String getNamePublish() {
        return namePublish;
    }

    public void setNamePublish(String namePublish) {
        this.namePublish = namePublish;
    }

    public String getAddressPublish() {
        return addressPublish;
    }

    public void setAddressPublish(String addressPublish) {
        this.addressPublish = addressPublish;
    }

    public String getEmailPublish() {
        return emailPublish;
    }

    public void setEmailPublish(String emailPublish) {
        this.emailPublish = emailPublish;
    }

    public String getPhonePublish() {
        return phonePublish;
    }

    public void setPhonePublish(String phonePublish) {
        this.phonePublish = phonePublish;
    }

    public String getRepresentPublish() {
        return representPublish;
    }

    public void setRepresentPublish(String representPublish) {
        this.representPublish = representPublish;
    }
}
