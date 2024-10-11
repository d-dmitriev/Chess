package home.work;

public interface UI {
    void printMessage(String message);
    void setCell(String symbol, int line, int column);
    void setLabel(String label, int line);
    void setRow(String label);
//    void waitUserInput();
//    void notifyUser();
}
