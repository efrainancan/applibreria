//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Libreria {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in); 
        System.out.println("------------------- MENÚ PRINCIPAL: -------------------");
        System.out.println("-------------------------------------------------------");
        String menu="";
        int opcionPrincipal=0;
        do{
            menu="";            
            menu+="1.- Ingrese estudiante\n";
            menu+="2.- Inngrese Docente \n";
            menu+="3.- Salir \n";
            menu+="Elia una opción";
            System.out.println(menu);
            opcionPrincipal=Integer.parseInt(sc.next());
            switch (opcionPrincipal) {
                case 1:
                    ingresoEstudiante();
                    break;
            
                default:
                    break;
            }
        }while(opcionPrincipal!=3);
        System.out.println("opcionPrincipal");
        System.out.println(opcionPrincipal);
       // Estudiante estudiante=new Estudiante("16316645-3", "Efraín Ancán", 'B', "Ingen");
/*        System.out.println("\n------------es");
        System.out.println(estudiante.isValido());
        System.out.println(estudiante);
 */

    }
    public static boolean ingresoEstudiante() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in); 
        //ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        //ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        
        System.out.println("Ingrese rut:");
        String rut=sc.next();
        boolean valido=validarRut(rut);
        if (valido) {
            Estudiante estudiante=new Estudiante("16316645-3", "Efraín Ancán", 'B', "Ingen");
            System.out.println("Estudiante ingresado!");            
            Estudiante.estudiantes.add(estudiante);
        }
        System.out.println("\nestudiantes:");
        System.out.println(Estudiante.estudiantes);
        System.out.println("\n");
        
        return true;
    }

    // MÉTODO PARA VALIDAR RUT
    public static boolean validarRut(String rut) {        
        boolean validacion = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
       
        return validacion;
    }
    
}
