package models;

public class Project {
    private String teacher_email;
    private String aclas;
    private String description;
    private String date;
    private String status;
    private String type;
    private String links;

    public Project(String teacher_email, String aclas, String description, String date, String status, String type, String links) {
        this.teacher_email = teacher_email;
        this.aclas = aclas;
        this.description = description;
        this.date = date;
        this.status = status;
        this.type = type;
        this.links = links;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }

    public String getAclas() {
        return aclas;
    }

    public void setAclas(String aclas) {
        this.aclas = aclas;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }
}
