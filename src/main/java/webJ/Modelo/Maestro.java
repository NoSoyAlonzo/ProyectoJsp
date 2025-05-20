package webJ.Modelo;

public class Maestro {
    private int id;
    private String nombre;
    private String email;
    private String contrasena;

    public Maestro(int id, String nombre, String email, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getContrasena() { return contrasena; }
}
