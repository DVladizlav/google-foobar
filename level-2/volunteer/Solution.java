import java.util.ArrayList;

public class Solution {

    public static int solution(int source, int destination) {
        if (source == destination){
            return 0;
        }

        Coord sourceCoord = new Coord(source);
        Coord destinationCoord = new Coord(destination);
        ArrayList<Coord> queue = possibleMoves(sourceCoord.x, sourceCoord.y);
        ArrayList<Coord> tempQueue = new ArrayList<>();
        int count = 0;

        while (true) {
            count++;
            for (Coord move : queue) {
                if (move.x == destinationCoord.x && move.y == destinationCoord.y) {
                    return count;
                }
                ArrayList<Coord> currentMoves = possibleMoves(move.x, move.y);
                for (Coord current : currentMoves) {
                    if (!tempQueue.contains(current)) {
                        tempQueue.add(current);
                    }
                }
            }
            queue = tempQueue;
            tempQueue = new ArrayList<>();
        }
    }

    static ArrayList<Coord> possibleMoves(int posX, int posY) {
        ArrayList<Coord> res = new ArrayList<>();
        Coord[] moves = new Coord[] {new Coord(posX + 2, posY + 1), new Coord(posX + 2, posY + 1),
                new Coord(posX + 2, posY - 1), new Coord(posX - 2, posY + 1),
                new Coord(posX - 2, posY - 1), new Coord(posX + 1, posY + 2),
                new Coord(posX + 1, posY - 2), new Coord(posX - 1, posY + 2),
                new Coord(posX - 1, posY - 2)};

        for (Coord move : moves) {
            if (move.x >= 0 && move.x < 8 && move.y >= 0 && move.y < 8) {
                res.add(move);
            }
        }
        return res;
    }

}


class Coord {
    public int x, y;

    public Coord(int pos) {
        this.x = pos / 8;
        this.y = pos % 8;
    }

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
