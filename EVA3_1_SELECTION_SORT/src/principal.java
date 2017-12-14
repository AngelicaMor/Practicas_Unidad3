
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ANGELICA MORENO MICHEL 16550454
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] iArreglo = new int[13];
        for (int i = 0; i < iArreglo.length; i++) {
            iArreglo[i] = (int) (Math.random() * 100);
        }
        imprimirArreglo(iArreglo);
        insertionSort(iArreglo);
        imprimirArreglo(iArreglo);
    }

    public static void imprimirArreglo(int[] Arreglo) {
        for (int i : Arreglo) {
            System.out.print("[" + i + "]");
        }
        System.out.println("");
    }

    //metodos de orenamiento
    

    public static void intercambiar(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

 
    public static void selectionSort(int[] Arreglo) {
        for (int i = 0; i < Arreglo.length; i++) {
            int min = Arreglo[i];
            int pM = i;
            for (int j = i + 1; j < Arreglo.length; j++) {
                if (Arreglo[j] < min) {
                    min = Arreglo[j];
                    pM = j;
                }
            }
            Arreglo[pM] = Arreglo[i];
            Arreglo[i] = min;
        }
    }


    public static void insertionSort(int[] a) {
        int i, j;
        int aux;
        for (i = 1; i < a.length; i++) {
            
            /* indice j es para explorar la sublista a[i-1]..a[0] buscando la
            posicion correcta del elemento destino*/
            
            j = i;
            aux = a[i];
            
            // se localiza el punto de inserción explorando hacia abajo
            
            while (j > 0 && aux < a[j - 1]) {
                
            // desplazar elementos hacia arriba para hacer espacio
                a[j] = a[j - 1];
                j--;
            }
            
            a[j] = aux;
        }
    }

    public static void bubbleSort(int a[]) {
        int i, j;
        for (i = 0; i < a.length - 1; i++) {
            for (j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    intercambiar(a, i, j);
                }
            }
        }
    }

    public static void quickSort(int a[]) {
        quick(a, 0, a.length - 1);
    }

    private static void quick(int a[], int primero, int ultimo) {
        int i, j, central;
        double pivote;
        central = (primero + ultimo) / 2;
        pivote = a[central];
        i = primero;
        j = ultimo;

        do {
            while (a[i] < pivote) {
                i++;
            }
            while (a[j] > pivote) {
                j--;
            }
            if (i <= j) {
                intercambiar(a, i, j);
                i++;
                j--;
            }
        } while (i <= j);

        if (primero < j) {
            quick(a, primero, j); 
        }

        if (i < ultimo) {
            quick(a, i, ultimo); 
        }
    }

    //metodos de busqueda
    public static int binarySearch(int arreglo[], int iValBus) {
        return binSearch(arreglo, iValBus, 0, arreglo.length - 1);
    }

    private static int binSearch(int arreglo[], int iValBus, int iLo, int iHi) {
        int iPos = -1;
        int iMid = iLo + ((iHi - iLo) / 2);
        if (iLo <= iHi) {
            if (iValBus == arreglo[iMid]) {
                iPos = iMid;
            } else if (iValBus > arreglo[iMid]) {
                iPos = binSearch(arreglo, iValBus, iMid + 1, iHi);
            } else if (iValBus < arreglo[iMid]) {
                iPos = binSearch(arreglo, iValBus, iLo, iMid - 1);
            }
        }
        return iPos;
    }
    

     public static  int busquedaSecuencial(int vector[], int Elem){
            for (int i = 0; i < vector.length; ++i)
                if (vector[i] == Elem)
                    return i;
            return -1;
      }
}
