package atm;
import java.util.Scanner;
public class ATM 
{
    public static void main(String[] args) 
    {
        // TODO code application logic here
        double saldo = 0, aux_movimientos;
        short depositos = 0,retiros = 0;
        short opc, aux;
        int nip = 1234;
        int claveUsuario;
        boolean continuar = true;
        Scanner lector = new Scanner(System.in);
        System.out.print("Teclea tu NIP de acceso: ");
        for(int i = 1;i<=3;i++)
        {
            claveUsuario = lector.nextInt();
            if(claveUsuario == nip)
            {
                i=4;
                System.out.println("Banco El buenPesito SA. de CV. \n");
                do
                {
                    System.out.println("-----------------------------");
                    System.out.println("Menu"
                            + "\n1.- Consulta de saldo"
                            + "\n2.- Retiro de efectivo"
                            + "\n3.- Depósito de efectivo"
                            + "\n4.- Consulta de movimientos"
                            + "\n5.- Salir \n");
                    System.out.println("-----------------------------");
                    System.out.println("Selecciona una de las opciones disponibles!");
                    opc = lector.nextShort();
                    switch(opc)
                    {
                        case 1:
                            System.out.println("-----------------------------");
                            System.out.println("Su saldo al día es de: $" + saldo + " Pesos");
                            System.out.println("-----------------------------");
                            break;
                        case 2:
                            System.out.println("-----------------------------------------------");
                            System.out.println("Teclea la cantidad a retirar: (Solo tengo billetes de $100, $200,$500, $1000)");
                            aux_movimientos = lector.nextDouble();
                            if(aux_movimientos>saldo)
                                System.out.println("--------------------------\nLo siento, no hay fondos suficientes!!!\n--------------------------");
                            else if((aux_movimientos%100 != 0))
                                System.out.println("DENOMINACIÓN INCORRECTA, REVISA LAS OPCIONES VALIDAS");
                            else
                            {
                                saldo-=aux_movimientos;
                                System.out.println("Se retiro $" + aux_movimientos + " Pesos");
                                System.out.println("Tome su efectivo");
                                System.out.println("-----------------------------");
                                retiros++;
                            }
                            aux_movimientos = 0;
                            break;
                        case 3:
                            System.out.println("-----------------------------");
                            System.out.print("Digite la cantidad a depositar: ");
                            aux_movimientos = lector.nextDouble();
                            if(aux_movimientos<=0)
                                System.out.println("La cantidad no debe ser negativa, ni cero");
                            else
                            {
                                System.out.println("Se depositará a su cuenta la cantidad de: $" + aux_movimientos + " Pesos");
                                saldo+=aux_movimientos;
                                depositos++;
                            }
                            System.out.println("-----------------------------");
                            break;
                        case 4:
                            System.out.println("Estos son sus movimientos: ");
                            System.out.println("-----------------------------");
                            System.out.println("Retiros: " + retiros);
                            System.out.println("Depósitos: " + depositos);
                            System.out.println("-----------------------------");
                            break;
                        case 5:
                            System.out.println("-----------------------------");
                            System.out.println("Estas seguro que deseas salir?  \n1.- Sí \n"
                                    + "2.- No \n");
                            System.out.println("-----------------------------");
                            aux = lector.nextShort();
                            if(aux == 1)
                                continuar = false;
                            else if(aux == 2)
                                continuar = true;
                            else
                                System.out.println("-----------------------------");
                                System.out.println("Opción no disponible, te dejaré continuar!");
                                System.out.println("-----------------------------");
                            break;
                        default:
                            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx");
                            System.out.println("Opción no disponible");
                            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx");
                            break;
                    }
                }while(continuar);
            }
            else
            {
                System.out.println("clave de acceso incorrecta, " + i + " Intentos");
                if(i == 3)
                    System.out.println("Bloqueaste tu cuenta!!!");
            }
        }
        System.out.println("El banco buenPesito SA. de CV. Agradece su preferencia!!!");
    }

}
