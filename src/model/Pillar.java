package model;

public class Pillar {

    private String nameP;
    private int numeroProjects;
    private Project[] projects;

    public Pillar(String nameP) {
        this.nameP = nameP;
        this.numeroProjects = 0;
        projects = new Project[50];
    }

    /**
     * Descripcion: Añade un nuevo Project al arreglo projects
     * pre: El arreglo projects debe estar inicializado
     * pos: El arreglo projects queda modificado con el nuevo Project
     * agregado
     * 
     * @param newProject Project El Project que se va a añadir
     * @return boolean true si se logra añadir el Project, false en caso
     *         contrario
     */
    public boolean registerProject(Project newProject) {

        if (numeroProjects < 50) {
            projects[numeroProjects++] = newProject;
            return true; // si se añadió
        }
        return false; // ya no hay espacio para más
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public int getnumeroProjects() {
        int contadorProjects = 0;
        
        
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null) {
                contadorProjects++;
            }
        }
        
        return contadorProjects;
    }

    /**
     * Descripcion: Genera una cadena en formato lista con la información de los
     * Project registrados en el Pillar
     * pre: El arreglo projects debe estar inicializado
     * 
     */
    public String getProjectList() {

        String list = "";

        boolean hayProject = false;
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null) {
                list="- " + projects[i].getId() + " Nombre: " + projects[i].getName() + ", Estado: " + projects[i].getStatus();
                hayProject = true;
            }
        }
        if (!hayProject) {
            list="No hay projectos registrados asociados al pillar.";
        }


        return list;
    }

 


}
