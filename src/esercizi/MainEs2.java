package esercizi;

import java.util.Random;

public class MainEs2 {
	private static final int ARRAY_SIZE = 3000;
	private static final int PARTITION_SIZE = 1000;
	private static final int NUM_THREADS = 3;

	public static void main(String[] args) {
		int[] array = generateRandomArray();
		int[] partialSums = new int[NUM_THREADS];
		Thread[] threads = new Thread[NUM_THREADS];

		for (int i = 0; i < NUM_THREADS; i++) {
			final int threadIndex = i;
			threads[i] = new Thread(() -> {
				int start = threadIndex * PARTITION_SIZE;
				int end = start + PARTITION_SIZE;
				int sum = 0;
				for (int j = start; j < end; j++) {
					sum += array[j];
				}
				partialSums[threadIndex] = sum;
			});
			threads[i].start();
		}

		// attesa di tutti i thread
		try {
			for (Thread thread : threads) {
				thread.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// somma dei risultati parziali dei thread
		int totalSum = 0;
		for (int i = 0; i < NUM_THREADS; i++) {
			totalSum += partialSums[i];
		}

		System.out.println("La somma degli elementi dell'array è: " + totalSum);
	}

	private static int[] generateRandomArray() {
		int[] array = new int[ARRAY_SIZE];
		Random random = new Random();
		for (int i = 0; i < ARRAY_SIZE; i++) {
			array[i] = random.nextInt(10);
		}
		return array;
	}
}
