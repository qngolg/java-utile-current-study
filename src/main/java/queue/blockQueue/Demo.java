package queue.blockQueue;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/24.
 */
public class Demo {

    PrintProcessor printProcessor;

    protected Demo(){
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    private void doTest(Request request){
        printProcessor.processRequest(request);
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setName("Mic");
        new Demo().doTest(request);
    }
}
