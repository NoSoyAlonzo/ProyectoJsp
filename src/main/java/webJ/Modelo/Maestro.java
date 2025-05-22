package webJ.Modelo;

public class Maestro {
    private int id;
    private String nombre;
    private String email;
    private String contrasena;

    public Maestro (){

    }

    public Maestro(int id, String nombre, String email, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
    }

    public Maestro(String nombre, String email, String contrasena) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }


    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getContrasena() { return contrasena; }
}
