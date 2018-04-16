public class ALQueueDriver{
    public static void main( String[] args ){
	ALQueue<String> frog  = new ALQueue<String>();
	frog.enqueue("frist");
	frog.enqueue("seocnd");
	System.out.println("peeking frog: " + frog.peekFront());	
	frog.dequeue();
	System.out.println("peeking frog: " + frog.peekFront());
    }
}
