
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomNumberBetween {

	public static void main(String[] args) {
		List<Integer> mendatory = new ArrayList<Integer>();
		mendatory.add(1);
		mendatory.add(2);
		mendatory.add(10);
	//	List<Integer> mendatory = Arrays.asList(1, 2, 10);

		List<Integer> list = generateQuestionSetFromList(10, 30, mendatory, true);
		System.out.println(list);

	}

	private static List<Integer> generateQuestionSetFromList(Integer QLimit, Integer TotalQ, List<Integer> mendatoryList, boolean random) {
		for (int i = mendatoryList.size(); i < QLimit; i++) {
			Integer No = 0;
			if(random) {
				No = getRandomNumberInRange(1, TotalQ);
			}else {
				No = i;
			}
			if (mendatoryList.contains(No)) {
				i--;
			} else {
				mendatoryList.add(No);
			}
		}
		if(random) {
		Collections.shuffle(mendatoryList);
		}
		return mendatoryList;
	}

	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}