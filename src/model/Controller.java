package model;

public class Controller {

    private Pillar[] pillars;

    private Pillar Pillar;

    public Controller() {

        pillars = new Pillar[4];
        crearPillar();

    }

    public void crearPillar(){

        pillars = new Pillar[4];

        pillars[0] = new Pillar("biodiversidad");
        pillars[1] = new Pillar("Agua");
        pillars[2] = new Pillar("Tratamiento de basuras");
        pillars[3] = new Pillar("Energia");
    }


    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema
     * 
     * @return boolean true si se logra añadir el Prject en el Pillar, false en caso
     *         contrario
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description,int status) {

        if (pillarType >= 0 && pillarType < pillars.length && pillars[pillarType] != null) {
            
            Project nuevoProject = new Project(id, name, description, status);
            return pillars[pillarType].registerProject(nuevoProject);
        } else {
            return false; 
        }

    }

    /**
     * Descripcion: Calcula el valor en dinero correspondiente al arrendamiento
     * mensual de todos los Edificios
     * pre: El arreglo edificios debe estar inicializado
     * 
     * @return String cadena en formato lista con la información de los
     * Project registrados en el Pillar
     */
    public String queryProjectsByPillar(int pillarType) {

        String imprimir= "";

        if (pillarType >= 0 && pillarType < pillars.length && pillars[pillarType] != null) {
            imprimir= pillars[pillarType].getProjectList();
        } else {
            imprimir="Índice del pillar no válido o no existe.";

        }

        return imprimir;

    }

    public void mostrarPillares(){

        System.out.println("Pillares disponibles:");
    for (int i = 0; i < pillars.length; i++) {
        Pillar pillar = pillars[i];
        if (pillar != null) {
            System.out.println((i + 1) + ". " + pillars[i].getNameP());
        }
    }
    }



}