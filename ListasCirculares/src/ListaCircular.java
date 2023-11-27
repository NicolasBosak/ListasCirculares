import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ListaCircular{
    List<MiembroEquipo> equipo;
    private int indiceActual;
    public ListaCircular(){
        equipo=new ArrayList<MiembroEquipo>();
        predefinir();
    }
    public void agregar(MiembroEquipo dato){
        equipo.add(dato);
    }
    public List<MiembroEquipo> getEquipo() {
        return equipo;
    }
    private boolean vacia() {
        return false;
    }
    public void predefinir(){
        equipo.add(new MiembroEquipo("Nicolas Casamen", "1755376140", 21, "Alero"));
        equipo.add(new MiembroEquipo("Anahi Quezada", "1725628598", 20, "Base"));
        equipo.add(new MiembroEquipo("Jeffereson Ruiz", "1752684213", 25, "Escolta"));
        equipo.add(new MiembroEquipo("Levi Ackerman", "1732695223", 28, "Pivot"));
        equipo.add(new MiembroEquipo("Anya Forger", "1752656398", 19, "Ala-Pivot"));
    }
    public List<MiembroEquipo> rotarJugadores() {
        if (vacia()) {
            return null;
        }
        MiembroEquipo primerJugador = equipo.remove(0);
        equipo.add(primerJugador);
        return equipo;
    }
}
