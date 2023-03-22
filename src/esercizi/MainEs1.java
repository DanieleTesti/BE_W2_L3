package esercizi;

public class MainEs1 {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new PrintSymbol("*"));
		Thread thread2 = new Thread(new PrintSymbol("#"));
		thread1.start();
		thread2.start();
	}

	static class PrintSymbol implements Runnable {
		private String symbol;

		public PrintSymbol(String symbol) {
			this.symbol = symbol;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.print(symbol + " ");
				try {
					Thread.sleep(1000); // attesa di 1 secondo tra una stampa e l'altra
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
