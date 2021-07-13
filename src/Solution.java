import java.util.Arrays;

class Solution {

    public String combineNum(Integer[] arr) {
        Arrays.sort(arr, (a, b) -> (b+""+a).compareTo (a+""+b));
        return combineAllElements(arr);
    }

    private String combineAllElements(Integer[] arr) {
        StringBuilder sb = new StringBuilder();
        for(Integer num : arr) {
            sb.append(num);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().combineNum(new Integer[]{10,15,60,6}));
    }
//    private static byte[] getByteArrayFromImageURL(String url) {
//
//        try {
//            URL imageUrl = new URL(url);
//            URLConnection ucon = imageUrl.openConnection();
//            InputStream is = ucon.getInputStream();
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            byte[] buffer = new byte[1024];
//            int read = 0;
//            while ((read = is.read(buffer, 0, buffer.length)) != -1) {
//                baos.write(buffer, 0, read);
//            }
//            baos.flush();
//            return baos.toByteArray();
//        } catch (Exception e) {
//        }
//        return null;
//    }
//    public static String encoder(byte[] imageData) {
//        String base64Image = "";
//            base64Image = Base64.getEncoder().encodeToString(imageData);
//        return base64Image;
//    }
//
//    public static void decoder(String base64Image, String pathFile) {
//        try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
//            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
//            imageOutFile.write(imageByteArray);
//        } catch (FileNotFoundException e) {
//            System.out.println("Image not found" + e);
//        } catch (IOException ioe) {
//            System.out.println("Exception while reading the Image " + ioe);
//        }
//    }
//    public static void main(String[] args) {
//        String ans =
//                encoder(getByteArrayFromImageURL("https://img.contactsplus.com/static/04877ac81467db7e5fe3f19c409e118a_3dfc79f7b0f368c50d03559743a0db9ddaedea6a7223fa93fe3400c120af5b2f"));
//        try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
//            writer.write(ans);
//        }
//        catch(IOException e){
//            // Handle the exception
//            e.printStackTrace();
//        }
//
//
//        System.out.println(ans);
//        decoder(ans, "/home/baghira/IdeaProjects/DataStructuresPractice/outpu.jpeg");
//    }

}