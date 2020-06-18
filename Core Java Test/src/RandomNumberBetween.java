
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberBetween {

	public static void main(String[] args) {
List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandomNumberInRange(1, 30));
		}

	}

	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}