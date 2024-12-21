import java.util.Scanner;

public class calculadoracientifica {
    private static final Scanner scanner = new Scanner(System.in);
    private static double[] resultados = new double[10]; // Arreglo para almacenar los resultados
    private static int index = 0; // Índice para insertar los resultados

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.iniciar();
        scanner.close();
    }

    // Método para mostrar resultados almacenados
    public static void mostrarResultados() {
        System.out.println("\n=== Resultados Almacenados ===");
        for (int i = 0; i < index; i++) {
            System.out.println("Resultado " + (i + 1) + ": " + resultados[i]);
        }
    }

    // Método para almacenar resultados
    public static void almacenarResultado(double resultado) {
        if (index < resultados.length) {
            resultados[index++] = resultado; // Almacenar el resultado
        } else {
            System.out.println("Error: No hay espacio para más resultados.");
        }
    }
}

class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final OperacionesBasicas operacionesBasicas = new OperacionesBasicas();
    private final OperacionesTrigonometricas operacionesTrigonometricas = new OperacionesTrigonometricas();
    private final OperacionesGeometricas operacionesGeometricas = new OperacionesGeometricas();

    public void iniciar() {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = obtenerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 4);
    }

    private void mostrarMenuPrincipal() {
        System.out.println("\n=== Calculadora Científica ===");
        System.out.println("1. Operaciones Básicas");
        System.out.println("2. Operaciones Trigonométricas");
        System.out.println("3. Cálculos Geométricos");
        System.out.println("4. Salir");
    }

    private int obtenerOpcion() {
        System.out.print("Seleccione una opción: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> operacionesBasicas.mostrarMenu();
            case 2 -> operacionesTrigonometricas.mostrarMenu();
            case 3 -> operacionesGeometricas.mostrarMenu();
            case 4 -> System.out.println("¡Gracias por usar la calculadora científica!");
            default -> System.out.println("Opción no válida");
        }
    }
}

class OperacionesBasicas {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n=== Operaciones Básicas ===");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Potencia");
        System.out.println("6. Raíz cuadrada");
        System.out.println("7. Mostrar resultados almacenados");
        System.out.println("8. Volver");

        int opcion = obtenerOpcion();
        realizarOperacion(opcion);
    }

    private int obtenerOpcion() {
        System.out.print("Seleccione una operación: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void realizarOperacion(int opcion) {
        double resultado;
        double num1, num2;

        switch (opcion) {
            case 1 -> {
                System.out.print("Ingrese el primer número: ");
                num1 = scanner.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                num2 = scanner.nextDouble();
                resultado = num1 + num2;
                System.out.println("Resultado: " + resultado);
                calculadoracientifica.almacenarResultado(resultado);
            }
            case 2 -> {
                System.out.print("Ingrese el primer número: ");
                num1 = scanner.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                num2 = scanner.nextDouble();
                resultado = num1 - num2;
                System.out.println("Resultado: " + resultado);
                calculadoracientifica.almacenarResultado(resultado);
            }
            case 3 -> {
                System.out.print("Ingrese el primer número: ");
                num1 = scanner.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                num2 = scanner.nextDouble();
                resultado = num1 * num2;
                System.out.println("Resultado: " + resultado);
                calculadoracientifica.almacenarResultado(resultado);
            }
            case 4 -> {
                System.out.print("Ingrese el dividendo: ");
                num1 = scanner.nextDouble();
                System.out.print("Ingrese el divisor: ");
                num2 = scanner.nextDouble();
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("Resultado: " + resultado);
                    calculadoracientifica.almacenarResultado(resultado);
                } else {
                    System.out.println("Error: División por cero");
                }
            }
            case 5 -> {
                System.out.print("Ingrese la base: ");
                num1 = scanner.nextDouble();
                System.out.print("Ingrese el exponente: ");
                num2 = scanner.nextDouble();
                resultado = Math.pow(num1, num2);
                System.out.println("Resultado: " + resultado);
                calculadoracientifica.almacenarResultado(resultado);
            }
            case 6 -> {
                System.out.print("Ingrese el número: ");
                num1 = scanner.nextDouble();
                if (num1 >= 0) {
                    resultado = Math.sqrt(num1);
                    System.out.println("Resultado: " + resultado);
                    calculadoracientifica.almacenarResultado(resultado);
                } else {
                    System.out.println("Error: No se puede calcular la raíz cuadrada de un número negativo");
                }
            }
            case 7 -> calculadoracientifica.mostrarResultados();
            case 8 -> System.out.println("Volviendo al menú principal.");
            default -> System.out.println("Opción no válida");
        }
    }
}

class OperacionesTrigonometricas {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n=== Operaciones Trigonométricas ===");
        System.out.println("1. Seno");
        System.out.println("2. Coseno");
        System.out.println("3. Tangente");
        System.out.println("4. Volver");

        int opcion = obtenerOpcion();
        realizarOperacion(opcion);
    }

    private int obtenerOpcion() {
        System.out.print("Seleccione una operación: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void realizarOperacion(int opcion) {
        if (opcion == 4) return;

        System.out.print("Ingrese el ángulo en grados: ");
        double angulo = scanner.nextDouble();
        double radianes = Math.toRadians(angulo);
        double resultado;

        switch (opcion) {
            case 1 -> {
                resultado = Math.sin(radianes);
                System.out.println("Seno: " + resultado);
                calculadoracientifica.almacenarResultado(resultado);
            }
            case 2 -> {
                resultado = Math.cos(radianes);
                System.out.println("Coseno: " + resultado);
                calculadoracientifica.almacenarResultado(resultado);
            }
            case 3 -> {
                if (Math.cos(radianes) != 0) {
                    resultado = Math.tan(radianes);
                    System.out.println("Tangente: " + resultado);
                    calculadoracientifica.almacenarResultado(resultado);
                } else {
                    System.out.println("Error: Tangente indefinida");
                }
            }
            default -> System.out.println("Opción no válida");
        }
    }
}

class OperacionesGeometricas {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n=== Cálculos Geométricos ===");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");
        System.out.println("6. Volver");

        int figura = obtenerOpcion("Seleccione una figura: ");
        int operacion = obtenerOpcion("¿Qué desea calcular? (1: Área, 2: Perímetro): ");
        calcular(figura, operacion);
    }

    private int obtenerOpcion(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void calcular(int figura, int operacion) {
        switch (figura) {
            case 1 -> calcularCirculo(operacion);
            case 2 -> calcularCuadrado(operacion);
            case 3 -> calcularTriangulo(operacion);
            case 4 -> calcularRectangulo(operacion);
            case 5 -> calcularPentagono(operacion);
            case 6 -> System.out.println("Volviendo al menú principal.");
            default -> System.out.println("Figura no válida");
        }
    }

    private void calcularCirculo(int operacion) {
        System.out.print("Ingrese el radio: ");
        double radio = scanner.nextDouble();
        if (operacion == 1) {
            System.out.println("Área del círculo: " + (Math.PI * radio * radio));
        } else {
            System.out.println("Perímetro del círculo: " + (2 * Math.PI * radio));
        }
    }

    private void calcularCuadrado(int operacion) {
        System.out.print("Ingrese el lado: ");
        double lado = scanner.nextDouble();
        if (operacion == 1) {
            System.out.println("Área del cuadrado: " + (lado * lado));
        } else {
            System.out.println("Perímetro del cuadrado: " + (4 * lado));
        }
    }

    private void calcularTriangulo(int operacion) {
        if (operacion == 1) {
            System.out.print("Ingrese la base: ");
            double base = scanner.nextDouble();
            System.out.print("Ingrese la altura: ");
            double altura = scanner.nextDouble();
            System.out.println("Área del triángulo: " + (base * altura / 2));
        } else {
            System.out.print("Ingrese los tres lados del triángulo: ");
            double lado1 = scanner.nextDouble();
            double lado2 = scanner.nextDouble();
            double lado3 = scanner.nextDouble();
            System.out.println("Perímetro del triángulo: " + (lado1 + lado2 + lado3));
        }
    }

    private void calcularRectangulo(int operacion) {
        System.out.print("Ingrese la base: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura: ");
        double altura = scanner.nextDouble();
        if (operacion == 1) {
            System.out.println("Área del rectángulo: " + (base * altura));
        } else {
            System.out.println("Perímetro del rectángulo: " + (2 * (base + altura)));
        }
    }

    private void calcularPentagono(int operacion) {
        System.out.print("Ingrese el lado: ");
        double lado = scanner.nextDouble();
        if (operacion == 1) {
            System.out.print("Ingrese el apotema: ");
            double apotema = scanner.nextDouble();
            System.out.println("Área del pentágono: " + (5 * lado * apotema / 2));
        } else {
            System.out.println("Perímetro del pentágono: " + (5 * lado));
        }
    }
}
