

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return "";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }
        if (line == toLine && column == toColumn) {
            return false;
        }

        int deltaX = Math.abs(toLine - line);
        int deltaY = Math.abs(toColumn - column);


        if (deltaX == deltaY) {
            int stepX = (toLine - line) > 0 ? 1 : -1;
            int stepY = (toColumn - column) > 0 ? 1 : -1;
            int currentLine = line + stepX;
            int currentColumn = column + stepY;


            while (currentLine != toLine && currentColumn != toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) {
                    return false;
                }
                currentLine += stepX;
                currentColumn += stepY;
            }


            return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getClass().equals(this.getClass());
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}