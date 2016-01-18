import java.io.File;

class EmptyStringFile {
    public static void main(String[] args) {
        File f = new File("");
        System.out.println(f.exists());
        System.out.println(f.getName());        
        System.out.println(f.isFile());
        System.out.println(f.getAbsolutePath());
    }
}