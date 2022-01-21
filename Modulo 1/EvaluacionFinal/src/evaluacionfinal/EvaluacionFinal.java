package evaluacionfinal;

import edu.formas.s8.evaluacion.Abonos;
import edu.formas.s8.evaluacion.Cliente;
import edu.formas.s8.evaluacion.ClientePersonaJuridica;
import edu.formas.s8.evaluacion.ClientePersonaNatural;
import edu.formas.s8.evaluacion.Cuenta;
import edu.formas.s8.evaluacion.Fecha;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EvaluacionFinal {

    private static int Menu() {
        int op = 0;
        String valores;
        valores = "Digite la Opcion \n";
        valores += "1.Agregar Clientes \n";
        valores += "2.Mostrar listas de clientes \n";
        valores += "3.Agregar cuentas  \n";
        valores += "4.Mostrar lista de cuentas \n";
        valores += "5.Hacer Abonos \n";
        valores += "6.Mostrar detalles de la cuenta \n";
        valores += "7.Salir \n";
        op = Integer.parseInt(JOptionPane.showInputDialog(valores));
        return op;
    }

    private static Cliente agregarCliente() {
        Cliente cli;
        int id, tipo;
        String nombre, apellido, documento, registro, ocupacion;
        ClientePersonaJuridica cpj;
        ClientePersonaNatural cpn;

        id = Integer.parseInt(JOptionPane.showInputDialog("Digite el id"));
        tipo = Integer.parseInt(JOptionPane.showInputDialog("Digite el tipo de Cliente CPJ=1, CPN=2 : "));

        if (tipo == 1) {
            nombre = JOptionPane.showInputDialog("Digite el nombre de la empresa: ");
            documento = JOptionPane.showInputDialog("Digite su numero de NIT : ");
            registro = JOptionPane.showInputDialog("Digite su numero de registro : ");
            cli = new ClientePersonaJuridica(id, nombre, "");
            cpj = (ClientePersonaJuridica) cli;
            cpj.setNit(documento);
            cpj.setRegistro(registro);
            return cpj;

        } else {
            nombre = JOptionPane.showInputDialog("Digite el nombre : ");
            apellido = JOptionPane.showInputDialog("Digite el apellido : ");
            documento = JOptionPane.showInputDialog("Digite su numero de DUI : ");
            ocupacion = JOptionPane.showInputDialog("Digite su ocupacion: ");
            cli = new ClientePersonaNatural(id, nombre, apellido);
            cpn = (ClientePersonaNatural) cli;
            cpn.setNumeroDui(documento);
            cpn.setOcupacion(ocupacion);
            return cpn;

        }

    }

    private static void mostrarListaCliente(ArrayList<Cliente> lista) {
        String cadena = "Id Nombre Apellido TipoCliente \n";
        if (lista == null || lista.size() == 0) {
            JOptionPane.showMessageDialog(null, "Aun no hay clientes");
        } else {

            for (Cliente cli : lista) {
                cadena += cli.getId() + " " + cli.getNombre() + " " + cli.getApellido() + " " + cli.getTipoCliente() + "\n";

            }
            JOptionPane.showMessageDialog(null, cadena);
        }
    }

    private static Cuenta agregarCuenta(ArrayList<Cliente> listaCli) {
        Cuenta cuenta;
        int numeroCuenta, idcli;
        Cliente cli;
        ArrayList<Abonos> abonos;
        float saldo;

        numeroCuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cuenta"));
        
        do{
        idcli = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del cliente"));
        cli = buscarCliente(listaCli, idcli);
        }while (cli == null);
        //Agregar abonos
        Fecha fechaAbono = new Fecha(16, 9, 2021);
        float montoAbono= Float.parseFloat(JOptionPane.showInputDialog("Ingrese el monto del abono"));
        Abonos abono = new Abonos(fechaAbono, montoAbono);
        
              
        cuenta = new Cuenta(numeroCuenta);
        cuenta.setCliente(cli);
        cuenta.addAbonos(abono);
        
        
        return cuenta;

    }

    private static Cliente buscarCliente(ArrayList<Cliente> list, int id) {
        Cliente cli= null;
        
        for(Cliente c : list){
            if(c.getId() == id){
                cli = c;
            }
        }
        if(cli == null){
            JOptionPane.showMessageDialog(null, "Id no encontrado");
        }
      //  System.out.println("Pruena"+cli);
       return cli;
    }

    private static void mostrarListaCuenta(ArrayList<Cuenta> lista) {
          String cadena = "NumeroCuenta Cliente Saldo \n";
        if (lista == null || lista.size() == 0) {
            JOptionPane.showMessageDialog(null, "Aun no hay cuentas");
        } else {

            for (Cuenta c : lista) {
                cadena += c.getNumeroCuenta() + " "+ c.getCliente().getNombre()+" "+c.consultarSaldo() + "\n";

            }
            JOptionPane.showMessageDialog(null, cadena);
        }
    }

    private static void agregarAbonos(ArrayList<Cuenta> lista) {
        int d,m,a;
        float monto;
        int numeroCuenta;
        Cuenta cuenta; 
        do{
        numeroCuenta=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de Cuenta"));    
        cuenta = buscarCuenta(lista, numeroCuenta);
        }
        while(cuenta == null);
        d=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia"));
        m=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes"));
        a=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el anio"));
        monto=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el monto a depositar"));
        
        Fecha fecha = new Fecha(d, m, a);
        Abonos abono = new Abonos(fecha, monto);
           

        cuenta.addAbonos(abono);
    }
    
    private static Cuenta buscarCuenta(ArrayList<Cuenta> lista, int numeroCuenta){
         Cuenta cuenta= null;
        
        for(Cuenta c : lista){
            if(c.getNumeroCuenta() == numeroCuenta){
                cuenta = c;
            }
        }
        if(cuenta == null){
            JOptionPane.showMessageDialog(null, "Cuenta no encontrado");
        }
      //  System.out.println("Pruena"+cli);
       return cuenta;
    }

    private static void mostrardetallesCuenta(ArrayList<Cuenta> lista) {
       int numeroCuenta;
       Cuenta cuenta;
       String cadena = "NCuenta Cliente FechaAbono Monto Saldo \n";
         do{
        numeroCuenta=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de Cuenta"));    
        cuenta = buscarCuenta(lista, numeroCuenta);
        }
        while(cuenta == null);
         
        for(Abonos ab: cuenta.getAbonos()){
            cadena += cuenta.getNumeroCuenta() + "|" + cuenta.getCliente().getNombre() +
                    "|" + ab.getFechaAbono().getFecha() +"|"+ ab.getMonto() + "|" + cuenta.consultarSaldo() + "\n";
        }
        
        JOptionPane.showMessageDialog(null, cadena);
    }

    public static void main(String[] args) {
        int op;
        ArrayList<Cliente> lstClientes = new ArrayList<>();
        ArrayList<Cuenta> lstCuentas = new ArrayList<>();

        do {
            op = Menu();
            switch (op) {
                case 1:
                    //Agregando clientes
                    lstClientes.add(agregarCliente());
                    break;
                case 2:
                    //Mostrar lista de clientes
                    mostrarListaCliente(lstClientes);
                    break;

                case 3:
                    //Agregar cuenta
                   lstCuentas.add(agregarCuenta(lstClientes));

                    break;

                case 4:
                    //Mostrar lista de cuentas
                    mostrarListaCuenta(lstCuentas);
                    
                    break;

                case 5:
                    //Hacer Abonos
                    agregarAbonos(lstCuentas);

                    break;
                case 6:
                    //Mostrar detalle de la cuenta
                    mostrardetallesCuenta(lstCuentas);
                    break;
                case 7:
                    //Salir
                    break;
                default:
                    //error
                    break;
            }
        } while (op != 7);
    }

}
