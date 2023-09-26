//package comp286.generics;

// building a class structure to practice Generics with
///						   File
///						/		\
///					   /		 \
///				Document		MediaFile
///				/	\				|	  \
///			   /     \				|	   \
///	OpenXMLDocument  PDFDocument  AudioFile VideoFile
///
abstract class File{
	private String name;
	private String location;
	private float size; // size in MB, may be decimal if its a small file

	public File(String name){
		this.name = name;
		location = "Unknown"; // if we don't set this, default value is null!
		size = -1; //negative 1 indicates size is not set
	}

	public abstract void open();

	public String getLocation(){
		return location;
	}

	public String getName(){
		return name;
	}

	//TODO: More methods...
} 

class Document extends File{
	private String language;

	public Document(String name){
		super(name);
		language = "English";
	}

	public void open(){
		System.out.println("Opening Document File "+getName()+" from "+getLocation());
	}
}

class MediaFile extends File{
	private int runtime; //length of media file in minutes

	public MediaFile(String name){
		super(name);
		// default value of int is automatically 0
	}
	
	public void open(){
		System.out.println("Opening Media File "+getName()+" from "+getLocation());
	}
}

//Open XML is the official name for .docx format
class OpenXMLDocument extends Document{
	
	public OpenXMLDocument(String name){
		super(name);
	}

	public void open(){
		System.out.println("Using default editor to open docx file: "+getName());
	}
}

class PDFDocument extends Document{
	private boolean isEncrypted;

	public PDFDocument(String name){
		super(name);
		isEncrypted = false; 
	}

	public void setEncrypted(boolean status){
		isEncrypted = status;
	}
	
}

class AudioFile extends MediaFile{
	public AudioFile(String name){
		super(name);
	}
	
}

class VideoFile extends MediaFile{

	private String rating;

	public VideoFile(String name){
		super(name);
		rating = "Not rated";
	}

	public void open(){
		System.out.println("Using default player to open video file from "+getLocation());
	}
}

class FileClassesTester{
	public static void main(String[] args) {
		Document d = new Document("test doc");
		OpenXMLDocument od = new OpenXMLDocument("docx example");

		VideoFile v = new VideoFile("movie");
		d.open();
		od.open();
		v.open();
	}
}