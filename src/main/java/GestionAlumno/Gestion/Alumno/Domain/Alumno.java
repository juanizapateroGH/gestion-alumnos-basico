package GestionAlumno.Gestion.Alumno.Domain;
    //Clase POJO
    public class Alumno {
        //Atributos
        private int id;
        private String nombre;
        private String email;
        private int edad;
        private String curso;

        //Constructor
        public Alumno(int id, String nombre, String email, int edad, String curso){
            this.id= id;
            this.nombre = nombre;
            this.email = email;
            this.edad = edad;
            this.curso = curso;
        }

        //Getters and Setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public String getCurso() {
            return curso;
        }

        public void setCurso(String curso) {
            this.curso = curso;
        }
    }


