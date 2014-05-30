
public class Count implements Runnable {
boolean running = true;
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++){
			if (Thread.currentThread().isInterrupted()){
				running = false;
				break;
			}
			
			else{
				if (running){
					System.out.println(i);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						this.kill();
					}
				}
			}

		}
		running = false;

	}
	public void kill(){
		running = false;
	}
}
