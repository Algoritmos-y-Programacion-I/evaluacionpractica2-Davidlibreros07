package model;

public class Project {

    private String id;
    private String name;
    private String description;
    private int status;

    public Project (String id, String name, String description,int status){

        this.id = id;
        this.name=name;
        this.description=description;
        this.status=status;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
