package com.letranson.email.model;

public class Email {
    private String languages;
    private int pageSize;
    private boolean spamFilters;
    private String Signature;

    public Email() {
    }

    public Email(String languages, int pageSize, boolean spamFilters, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamFilters = spamFilters;
        Signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFilters() {
        return spamFilters;
    }

    public void setSpamFilters(boolean spamFilters) {
        this.spamFilters = spamFilters;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }
}
