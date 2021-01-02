package com.example.topnote.Models;

public class NoteModel {
    String Name;
    String Link;
    String TrustedBy;
    String by;
    String Date;
    String Description;
    String CoverImage;
    String Branch;

    public NoteModel(String name, String link, String trustedBy, String by, String date, String description,String coverImage,String branch) {
        Name = name;
        Link = link;
        TrustedBy = trustedBy;
        this.by = by;
        Date = date;
        Description = description;
        CoverImage = coverImage;
        Branch = branch;
    }

    public NoteModel() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getTrustedBy() {
        return TrustedBy;
    }

    public void setTrustedBy(String trustedBy) {
        TrustedBy = trustedBy;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCoverImage() {
        return CoverImage;
    }

    public void setCoverImage(String coverImage) {
        CoverImage = coverImage;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }
}
