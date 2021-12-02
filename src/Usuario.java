public class Usuario {
    private int id;
    private String username;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public Usuario(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(String username) {
        this.username = username;
    }
}
