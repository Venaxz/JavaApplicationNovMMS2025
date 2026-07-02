public class BreakStatement {
    public static void main(String[] args) {
        for (int i = 2; i <= 20; i++) {
			
			System.out.printf("%d%n", i);

            if (i == 15) {
                break;
            }
        }
    }
}