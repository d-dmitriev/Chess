package home.work.ui.console;

import home.work.UI;

import java.util.Scanner;

public final class ChessConsole implements UI {
    //Константы
    static final String BAD_FORMAT = "Не верный формат! Поддерживаются только целые числа.";
    //Экземпляр сканера
    static Scanner scanner = new Scanner(System.in);
    //Запрос операнда
    public static int readOperand(String message) {
        writeResponse(message);
        while (!scanner.hasNextInt()) {
            writeResponse(BAD_FORMAT);
            scanner.next();
        }
        return scanner.nextInt();
    }
    //Запрос оператора
    public static String readCommand(String message) {
        writeResponse(message);
        return scanner.next();
    }
    public static String readLine() {
        return scanner.nextLine();
    }
    //Вывод сообщения
    public static void writeResponse(String message) {
        System.out.println(message);
    }
    //Вывод числа
    public static void writeResponse(double message) {
        System.out.println(message);
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void setCell(String symbol, int line, int column) {
        System.out.print(symbol);
    }

    @Override
    public void setLabel(String label, int line) {
        System.out.print(label);
    }

    @Override
    public void setRow(String label) {
        System.out.println(label);
    }
}
