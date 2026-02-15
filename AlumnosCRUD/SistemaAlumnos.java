package AlumnosCRUD;

public class SistemaAlumnos {

    
    private Alumno[] alumnos = new Alumno[25];


    public boolean altaAlumno(int ID, String nombre, double promedio) {
       //VALIDACIONES
        if (ID <= 0) return false;
        if (nombre == null || nombre.trim().isEmpty()) return false;
        if (promedio < 0 || promedio > 10) return false;
        if (existeId(ID)) return false;

        int pos = obtenerPosicionLibre();
        if (pos == -1) return false; 

        alumnos[pos] = new Alumno(ID, nombre.trim(), promedio);
        return true;
    }

    private int obtenerPosicionLibre() {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) return i;
        }
        return -1;
    }

    private boolean existeId(int ID) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].ID == ID) {
                return true;
            }
        }
        return false;
    }

    
    public Alumno buscarActivoPorId(int ID) {
        int pos = buscarPosicionActivoPorId(ID);
        if (pos == -1) return null;
        return alumnos[pos];
    }

    private int buscarPosicionActivoPorId(int ID) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].activo && alumnos[i].ID == ID) {
                return i;
            }
        }
        return -1;
    }

  
    public boolean actualizarPromedioActivo(int id, double nuevoPromedio) {
        if (nuevoPromedio < 0 || nuevoPromedio > 10) return false;

        int posicion = buscarPosicionActivoPorId(id);
        if (posicion == -1) return false;

        alumnos[posicion].promedio = nuevoPromedio;
        return true;
    }

    
    public int bajaLogica(int id) {
      
        int posicion = buscarPosicionPorId(id);
        if (posicion == -1) return 0;

        if (!alumnos[posicion].activo) return -1;

        alumnos[posicion].activo = false;
        return 1;
    }

    private int buscarPosicionPorId(int ID) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].ID == ID) {
                return i;
            }
        }
        return -1;
    }

    
    public void listarActivos() {
    boolean vacio = false;

    String sep = "+--------+------------------------------+-----------+\n";
    System.out.print("\n--- LISTA DE ALUMNOS ACTIVOS ---\n");
    System.out.print(sep);
    System.out.printf("| %-6s | %-28s | %-9s |\n", "ID", "Nombre", "Promedio");
    System.out.print(sep);

    for (int i = 0; i < alumnos.length; i++) {
        if (alumnos[i] != null && alumnos[i].activo) {
            vacio = true;
            System.out.printf("| %-6d | %-28s | %9.2f |\n",
                    alumnos[i].ID,
                    recortar(alumnos[i].nombre, 28),
                    alumnos[i].promedio);
        }
    }
    if (vacio) {
        System.out.print(sep);
    } else {
        System.out.print("| No hay alumnos activos.|\n");
        System.out.print(sep);
    }
}

private String recortar(String s, int max) {
    if (s == null) return "";
    s = s.trim();
    return s.length() <= max ? s : s.substring(0, max - 1) + "…";
}

    
    public void mostrarReportes() {
        int alumAct = 0;
        double suma = 0;

        Alumno mayor = null;
        Alumno menor = null;

        int mayorIgual8 = 0;

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].activo) {
                Alumno a = alumnos[i];
                alumAct++;
                suma += a.promedio;

                if (a.promedio >= 8.0) mayorIgual8++;

                if (mayor == null || a.promedio > mayor.promedio) mayor = a;
                if (menor == null || a.promedio < menor.promedio) menor = a;
            }
        }

        System.out.println("\n-------REPORTE-------");
        if (alumAct == 0) {
            System.out.println("No hay alumnos activos para generar reportes.");
            return;
        }

        double promedioGe = suma / alumAct;
        System.out.println("Promedio general de alumnos ACTIVOS: " + promedioGe);

        System.out.println("\nAlumno activo con mayor promedio:");
        System.out.println("ID: " + mayor.ID + " | Nombre: " + mayor.nombre + " | Promedio: " + mayor.promedio);

        System.out.println("\nAlumno activo con menor promedio:");
        System.out.println("ID: " + menor.ID + " | Nombre: " + menor.nombre + " | Promedio: " + menor.promedio);

        System.out.println("\nCantidad de alumnos activos con promedio >= 8.0: " + mayorIgual8);
    }
}