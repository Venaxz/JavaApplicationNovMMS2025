public class ReturnStatement {
    public static void main(String[] args) {
        System.out.println("The area of the rectangle is " + areaofRectangle(7, 20));
        System.out.println("The area of the rectangle is " + areaofRectangle(30, 50));
        System.out.println("The area of the rectangle is " + areaofRectangle(13, 130));
        System.out.println("The area of the rectangle is " + areaofRectangle(37, 90));
        System.out.println("The area of the rectangle is " + areaofRectangle(71, 111));
    }

    public static int areaofRectangle(int length, int height) {
        int area = length * height;

        return area;
    }
}