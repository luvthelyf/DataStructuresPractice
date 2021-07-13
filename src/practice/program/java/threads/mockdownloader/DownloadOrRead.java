package practice.program.java.threads.mockdownloader;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class DownloadOrRead {
        
    //Utility method, which just generates a random String instance...
    private static String randomString(final int length) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        alphabet += alphabet.toUpperCase();
        alphabet += "0123456789";
        final int alphabetSize = alphabet.length();
        final char[] chars = new char[length];
        final Random rand = new Random();
        for (int i = 0; i < chars.length; ++i)
            chars[i] = alphabet.charAt(rand.nextInt(alphabetSize));
        return String.valueOf(chars);
    }
    
    public static class DownLoadCallable implements Callable<String> {
        private final String url;
        
        public DownLoadCallable(final String url) {
            this.url = Objects.requireNonNull(url);
        }

        @Override
        public String call() throws IOException, InterruptedException {
            
            /*Utilize url property here to download the file...
            In our case, just simulate a download delay supposedly...*/
            Thread.sleep(3000L + (long) (Math.random() * 1000L));
            
            //Return the file's local path...
            return url+" some file"; //In our case, a random String of 20 characters.
        }
    }
    
    //This is the method you are looking for:
    public static String loadPath(final ExecutorService executorService, //Can be shared between calls of loadPath...
                                  final HashMap<String, Future<String>> urlToFuture, //MUST be shared between calls of loadPath!
                                  final String url) //The URL. Can be the same as a URL in a previous call of loadPath.
            throws InterruptedException, ExecutionException {
        final Future<String> future;
        synchronized (Collections.unmodifiableMap(urlToFuture)) {
            if (!urlToFuture.containsKey(url)) { //If nowhere to be seen...
                System.out.println("starting download "+url);
                urlToFuture.put(url, executorService.submit(new DownLoadCallable(url))); //Create a Future...
            }
            future = urlToFuture.get(url); //Obtain the Future (new or old).
        }
        System.out.println("reading url ="+url);
        return future.get(); //Outside the synchronized block!
    }
    
    public static void main(final String[] args) {
        
        System.out.println("Creating ExecutorService...");
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        
        System.out.println("Creating shared map...");
        final HashMap<String, Future<String>> urlToFuture = new HashMap<>();
        
        System.out.println("Creating random URLs...");
        final String[] urls = new String[]{"abc", "jbc"/*, "abc","abc","abc","abc"*/};
        
        try {
            System.out.println("Downloading files sequencially...");
            final Random rand = new Random();
            for (int i = 0; i < 10; ++i)
                System.out.println(loadPath(executorService, urlToFuture, urls[rand.nextInt(urls.length)]));
            
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        }
        catch (final InterruptedException | ExecutionException x) {
            System.err.println(x);
        }
    }
}