package home.work.game;

public class Castling {
    private final Game game;

    public Castling(Game game) {
        this.game = game;
    }

    public boolean run(int line, int kingPosition, int rookPosition, int newKingPosition, int newRookPosition) {
        if (game.isEmptyCell(line, rookPosition) || game.isEmptyCell(line, kingPosition))
            return false; // Не выполнять если клетки пустые
        if (!game.isCurrentPlayerPieceOnCell(line, rookPosition) || !game.isCurrentPlayerPieceOnCell(line, kingPosition))
            return false; // Не выполнять если не свои фигуры
        if (!game.isRookOnCell(line, rookPosition) || !game.isKingOnCell(line, kingPosition))
            return false; // Не выполнять если не Король или не Ладья на клетках
        if (!game.isLineBetweenCellEmpty(line, kingPosition, line, rookPosition))
            return false; // Не выполнять если есть фигуры между Королем и Ладьей
        if (game.isPieceOnCellMoved(line, rookPosition) || game.isPieceOnCellMoved(line, kingPosition))
            return false; // Не выполнять если Король или Ладья двигались
        if (game.isNotUnderAttack(line, kingPosition) // Проверка не под атакой ли клетка Короля
                && game.isNotUnderAttack(line, newKingPosition) // Проверка не под атакой ли клетка в которую идет Король
                && game.isNotUnderAttack(line, kingPosition + (newKingPosition - kingPosition) / 2)) {// Проверка не под атакой ли клетка через которую Король проходит
            game.movePieceToPosition(line, kingPosition, line, newKingPosition); // Перемещение Короля
            game.movePieceToPosition(line, rookPosition, line, newRookPosition); // Перемещение Ладьи
            return true;
        } else return false;
    }
}
