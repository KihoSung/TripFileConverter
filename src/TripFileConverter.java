import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TripFileConverter
{
	/**
	 * Trip File 경로
	 */
	private final String STR_FILE_PATH = "C:\\PDS\\PC_PDS\\Data";

	private final String STR_ENC_STATUS = "E"; // P : 평문 , E : 암호화 //

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		TripFileConverter tfc = new TripFileConverter();

		// 파일 목록 불러오기 //
		File listFile[] = tfc.getFileList(tfc.STR_FILE_PATH);

		try
		{
			tfc.converterFiles(listFile);
		}
		catch (IOException ioe)
		{

		}

	}

	private void converterFiles(File listFile[]) throws IOException
	{
		for (File file : listFile)
		{
			String strFileName = file.getName();

			this.convertTripData(file);
		}
	}

	private void convertTripData(File file) throws IOException
	{
		String strFileName = file.getName();
		
		if (strFileName.contains("-X-"))
		{
			TsEncriptData.decTripData(new FileInputStream(file), file.getName(), this.STR_FILE_PATH);
		}
		else if (strFileName.contains("-S-"))
		{
			TsEncriptData.encTripData(new FileInputStream(file), file.getName(), this.STR_FILE_PATH);
		}
	}

	/**
	 * 경로에 있는 파일 목록 불러오기
	 * 
	 * @param strFilePath
	 * @return
	 */
	private File[] getFileList(String strFilePath)
	{
		// this.writeLog("[getFileList] strFilePath : " + strFilePath);

		File f = new File(strFilePath);

		File listFile[] = f.listFiles();

		// this.writeLog("[getFileList] listFile.length : " + listFile.length);

		return listFile;
	}

}
