package GestionAlumno.Gestion.Alumno.Controller;

import GestionAlumno.Gestion.Alumno.Domain.Alumno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    //Creamos una lista simulando la base de datos
    private List<Alumno> alumnos = new ArrayList<>(Arrays.asList(
            new Alumno(1, "Juan Ignacio Zapatero", "zapaterojuan3@gmail.com", 19, "2do TM"),
            new Alumno(2, "Emily Magali Sedran", "emilysedran@gmail.com", 20, "2do Diseño")
    ));


    /**
     * Metodo en el que constultamos los alumnos
     * @return alumnos
     */
    @GetMapping
    public List <Alumno> getAlumnos(){
        return alumnos;
    }

    /**
    Metodo en el cual consultamos alumnos por su email
    @param email del alumno
    @return Alumno
     */
    @GetMapping("/{email}")
    public Alumno getAlumnoPorEmail(@PathVariable String email){
        for (Alumno a : alumnos){
            if (a.getEmail().equalsIgnoreCase(email)){
                return a;
            }
        }
        return null;
    }

    /**
     * Metodo para crear Alumno
     * @param alumno
     * @return El alumno nuevo
     */
    @PostMapping
    public Alumno postAlumno(@RequestBody Alumno alumno){
        alumnos.add(alumno);
        return alumno;
    }

    /**
     * Metodo en que cambiamos todos los valores de un alumno
     * @param alumno
     * @return Alumno Actualizado
     */
    @PutMapping
    public Alumno putAlumno(@RequestBody Alumno alumno){
        for(Alumno a : alumnos){
            a.setNombre(alumno.getNombre());
            a.setEdad(alumno.getEdad());
            a.setCurso(a.getCurso());
            a.setEmail(alumno.getEmail());
            return a;
        }
        return null;
    }

    /**
     * Metodo para modificar cualquier atributo
     * @param alumno
     * @return Alumno actualizado
     */
    @PatchMapping
    public Alumno patchAlumno(Alumno alumno){
        for (Alumno a : alumnos){
            if (a.getId() == alumno.getId()){
                if(a.getNombre() != null){
                    a.setNombre(alumno.getNombre());
                }
                if(a.getEdad() != 0){
                    a.setEdad(alumno.getEdad());
                }
                if (a.getEmail() != null){
                    a.setEmail(alumno.getEmail());
                }
                if (a.getCurso() != null){
                    a.setCurso(alumno.getCurso());
                }
                return a;
            }
        }
        return null;
    }

    /**
     * Metodo en que eliminamos a un Alumno segun su id
     * @param id
     * @return alumno removido
     */
    @DeleteMapping("/{id}")
    public Alumno deleteAlumno (@PathVariable int id){
        for (Alumno a : alumnos){
            if (a.getId() == id){
                alumnos.remove(a);
                return a;
            }
        }
        return null;
    }
}
