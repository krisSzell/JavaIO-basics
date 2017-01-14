import java.io.*;
import java.util.Scanner;

class Stream
{
	public static String fileName = "";

	public Stream(String arg)
	{
		fileName = arg;
	}

	// wyswietlanie listy plikow w katalogu
	public static void list()
	{
		File dir = new File(fileName);

		if (dir.exists())
		{
			String[] files = dir.list();
			System.out.println(files.length + " file(s) found.");
			for (int i = 0; i < files.length; i++)
			{
				System.out.println(files[i]);
			}
		}
		else
		{
			System.out.println("Directory doesn't exist.");
		}

	}

	// czytanie plikow
	public static void read() throws IOException
	{
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String txt = "";

		while ((txt = bufferedReader.readLine()) != null)
		{
			System.out.println(txt);
		}

		bufferedReader.close();
	}

	public static void readAndCopy(String fileCopyName) throws IOException
	{
		LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(fileName));

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileCopyName));

		String txt = "";

		while ((txt = lineNumberReader.readLine()) != null)
		{
			bufferedWriter.write("|" + lineNumberReader.getLineNumber() + " " + txt);
			bufferedWriter.newLine();
		}


		lineNumberReader.close();
		bufferedWriter.close();
	}

	public static void write() throws IOException
	{
		String txt = "";
		String data = "";

		System.out.println("Wprowadz tekst do zapisania do pliku: ");
		Scanner input = new Scanner(System.in);
		txt = input.nextLine();
		FileWriter fileWriter = new FileWriter(fileName);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		while (!"quit".equals(txt))
		{
			bufferedWriter.write(txt);
			bufferedWriter.newLine();
			txt = input.nextLine();
		}

		bufferedWriter.close();
	}

    static void copy(InputStream in, OutputStream out) throws IOException
	{
          int c;
          while ((c = in.read()) != -1) out.write(c);       
	}
    static void copy(Reader in, Writer out) throws IOException 
	{
          int c;
          while ((c = in.read())!= -1) out.write(c);       
	}
}