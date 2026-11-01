
package com.carnecol;

import com.carnecol.dao.ProductoDAO;
import com.carnecol.modelo.Producto;
import java.util.List;
import java.util.Scanner;

public class Carnecol {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ProductoDAO productoDAO = new ProductoDAO();

        int opcion;

        do {
            System.out.println("\n===== APP CARNECOL =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Consultar productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = teclado.nextLine();

                    System.out.print("Precio: ");
                    double precio = teclado.nextDouble();

                    System.out.print("Stock: ");
                    int stock = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Descripcion: ");
                    String descripcion = teclado.nextLine();

                    Producto nuevo = new Producto(
                            0, nombre, categoria, precio, stock, descripcion
                    );

                    System.out.println(productoDAO.insertar(nuevo)
                            ? "Producto registrado correctamente."
                            : "No se pudo registrar.");
                    break;

                case 2:
                    List<Producto> productos = productoDAO.consultar();

                    for (Producto p : productos) {
                        System.out.println(
                                p.getIdProducto() + " | "
                                + p.getNombre() + " | "
                                + p.getCategoria() + " | $"
                                + p.getPrecio() + " | Stock: "
                                + p.getStock()
                        );
                    }
                    break;

                case 3:
                    System.out.print("ID del producto: ");
                    int idActualizar = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = teclado.nextLine();

                    System.out.print("Nueva categoria: ");
                    String nuevaCategoria = teclado.nextLine();

                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = teclado.nextDouble();

                    System.out.print("Nuevo stock: ");
                    int nuevoStock = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Nueva descripcion: ");
                    String nuevaDescripcion = teclado.nextLine();

                    Producto actualizado = new Producto(
                            idActualizar, nuevoNombre, nuevaCategoria,
                            nuevoPrecio, nuevoStock, nuevaDescripcion
                    );

                    System.out.println(productoDAO.actualizar(actualizado)
                            ? "Producto actualizado correctamente."
                            : "No se pudo actualizar.");
                    break;

                case 4:
                    System.out.print("ID del producto a eliminar: ");
                    int idEliminar = teclado.nextInt();

                    System.out.println(productoDAO.eliminar(idEliminar)
                            ? "Producto eliminado correctamente."
                            : "No se pudo eliminar.");
                    break;

                case 5:
                    System.out.println("Gracias por utilizar Carnecol.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 5);

        teclado.close();
    }
}
