package Project;

import java.util.*;

public class ItemPacking {

	public static ArrayList<Double> part1(Double[] itemWeights) { //O(n^2)

		PriorityQueue<Double> boxes = new PriorityQueue<>(itemWeights.length);
		ArrayList<Double> FullBox = new ArrayList<>();

		boxes.add(0.0);

		for(int i = 0; i < itemWeights.length; i++) {
			if (boxes.peek() != null) {
				if (itemWeights[i] + boxes.peek().doubleValue() > 1) {
					FullBox.add(boxes.poll());
					boxes.add(0.0);
				}
				if (i == itemWeights.length - 1) {
					boxes.add(itemWeights[i] + boxes.poll().doubleValue());
					FullBox.add(boxes.poll());
				}
				boxes.add(itemWeights[i] + boxes.poll().doubleValue());
			}
			boxes.addAll(FullBox);
		}
		return FullBox;
	}

	public static ArrayList<Double> part2(Double[] itemWeights) {//O(N^2logn)
		Arrays.sort(itemWeights, Collections.reverseOrder());

		PriorityQueue<Double> boxes = new PriorityQueue<>(itemWeights.length);
		ArrayList<Double> FullBox = new ArrayList<>();

		boxes.add(0.0);

		for(int i = 0; i < itemWeights.length; i++) {

			if (boxes.peek() != null) {
				if (itemWeights[i] + boxes.peek().doubleValue() > 1) {
					FullBox.add(boxes.poll());
					boxes.add(0.0);
				}
				boxes.add(itemWeights[i] + boxes.poll().doubleValue());

			}
		}
		FullBox.add(boxes.poll());

		return FullBox;

	}

	public static double[] part3(Double[] itemWeights){ //O(N^2)

		double[] boxes = new double[itemWeights.length];

		for (int i=0;i<itemWeights.length;i++){
			for (int j=0;j<boxes.length;j++){
				if (itemWeights[i]+boxes[j] <= 1) {
					boxes[j] += itemWeights[i];
					break;
				}
			}
		}

		return boxes;
	}

	public static void main(String[] args) {

		Double[] items = {.4,.6,.3,.2,.8};
		ArrayList<Double> p = part1(items);
		ArrayList<Double> p2 = part2(items);
		double[] outputs = part3(items);

		for (int i=0;i<p.size();i++){
			System.out.print(p.get(i) + " ");
		}
		System.out.println();
		for (int i=0;i<p.size();i++){
			System.out.print(p2.get(i) + " ");
		}
		System.out.println();
		for(int i = 0; i < outputs.length; i++) {
			System.out.print(outputs[i] + " ");
		}
	}
}
