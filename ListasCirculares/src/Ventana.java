import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Ventana {
    private JPanel Equipos;
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JComboBox cboPosicion;
    private JButton btnIngresar;
    private JTextField txtEdad;
    private JTabbedPane tabbedPane1;
    private JList lstDatos;
    private JButton btnListar;
    private JList lstListado;
    private JButton btnRotar;
    private JList lstRotar;
    private ListaCircular equipo = new ListaCircular();

    private void llenarJlist(){
        List<MiembroEquipo> listado=equipo.getEquipo();
        DefaultListModel dlm=new DefaultListModel();
        for(MiembroEquipo m:listado){
            dlm.addElement(m.toString());
        }
        lstDatos.setModel(dlm);
        lstListado.setModel(dlm);
    }
    public void llenarJlistRotar() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (int i = 0; i < 5 && i < equipo.getEquipo().size(); i++) {
            MiembroEquipo m = equipo.getEquipo().get(i);
            modelo.addElement(m.toString());
        }
        lstRotar.setModel(modelo);
    }

    public Ventana() {
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String cedula = txtCedula.getText();
                String edadStr = txtEdad.getText();
                int edad = Integer.parseInt(edadStr);
                String rol = (String) cboPosicion.getSelectedItem();

                MiembroEquipo miembroEquipo=new MiembroEquipo(nombre,cedula,edad,rol);
                equipo.agregar(miembroEquipo);
                llenarJlist();
                JOptionPane.showMessageDialog(null,"Nuevo registro");
                txtNombre.setText("");
                txtCedula.setText("");
                txtEdad.setText("");
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llenarJlist();
            }
        });
        btnRotar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipo.rotarJugadores();
                    llenarJlistRotar();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Equipos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
