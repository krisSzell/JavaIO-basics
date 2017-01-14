import java.io.*;
public class Kopiowanie
{
    public static void main (String args[])
    {
        try
        {
            // test metod czytajacych i piszacych do pliku
            Stream myStream = new Stream("test.txt");
            //myStream.write();
            //myStream.read();

            // Kopiowanie plikow
            //InputStream inputStream = new FileInputStream("test.txt");
            //OutputStream outputStream = new FileOutputStream("textCopy.txt");
//
            //Stream.copy(inputStream, outputStream);
            Stream.readAndCopy("zadanie4test.txt");
        }
        catch (IOException ex)
        {
            System.out.println("Błąd");
        }
    }

}