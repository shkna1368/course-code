public class MovablePoint implements Movable,Hi{
    private int x, y;   // (x, y) coordinates of the point

    // Constructor
    public MovablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

 /*   @Override
    public String toString() {

        return "(" + x + "," + y + ")";
    }*/

    // Need to implement all the abstract methods defined in the interface Movable
    @Override
    public void moveUp() {
        y++;
    }
    @Override
    public void moveDown() {
        y--;
    }
    @Override
    public void moveLeft() {
        x--;
    }
    @Override
    public void moveRight() {
        x++;
    }
}
