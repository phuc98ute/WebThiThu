package Controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Model.CAUHOI_DAO;
import Objects.CauHoi;
@MultipartConfig
public class importExcelFile {
	public importExcelFile() {
		// TODO Auto-generated constructor stub
	}
	public static boolean DeleteFile(String filePath) {
		File file = new File(filePath);

		if (file.exists()) {
			file.delete();
			return true;
		}

		return false;
	}

	public static String createFoderUploadFile(HttpServletRequest request) {
		String appPath = request.getServletContext().getRealPath("");
		appPath = appPath.replace("\\", "/");

		// t?o thu m?c t?i l�n
		String saveFullPath = null;
		if (appPath.endsWith("/")) {
			saveFullPath = appPath + "importDir";

		} else {
			saveFullPath = appPath + "/" + "importDir";

		}
		File fileSaveDir = new File(saveFullPath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		return saveFullPath;

	}

	public static String upLoadFile(HttpServletRequest request, String saveFullPath) {
		try {
			System.out.print(request.getParts().size());
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (fileName != null && fileName.length() > 0) {
					String filePath = saveFullPath + File.separator + fileName;
					part.write(filePath);
					return filePath;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}

	private static String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				// C:\file1.zip
				// C:\Note\file2.zip
				String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
				clientFileName = clientFileName.replace("\\", "/");
				int i = clientFileName.lastIndexOf('/');
				// file1.zip
				// file2.zip
				return clientFileName.substring(i + 1);
			}
		}
		return null;
	}

	public static boolean readAndWriteFileExcel(String filePath) throws IOException {
		CauHoi question=null;
		//Answer answer=null;
		
		
		DataFormatter fmt = new DataFormatter();
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		Workbook workbook = new XSSFWorkbook(inputStream);
		org.apache.poi.ss.usermodel.Sheet datatypeSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = datatypeSheet.iterator();
		try {
			while (iterator.hasNext()) {
				int idCurrentQus;
				question=new CauHoi();
				question.setMaCauHoi(1);
				//question.setSubjectID(idSubject);
				
				
				//L?y t?ng h�ng c?a sheet
				Row currentRow = iterator.next();
				
				
				//L?y t?t c? cell c?a Hang
				Iterator<Cell> cellIterator = currentRow.cellIterator();
				
				Cell cellNoidung = cellIterator.next();
				question.setNoiDungCauHoi((cellNoidung+""));
				
				Cell cellMucdo = cellIterator.next();
				String s= cellMucdo+"";
				
				
				Cell dapanA = cellIterator.next();
				question.setDapAn_A((dapanA+""));
				
				Cell dapanB = cellIterator.next();
				question.setDapAn_B((dapanB+""));
				
				Cell dapanC = cellIterator.next();
				question.setDapAn_C((dapanC+""));
				
				Cell dapanD = cellIterator.next();
				question.setDapAn_D((dapanD+""));
				
				Cell dapanDung = cellIterator.next();
				question.setDapAnDung((dapanDung+""));
				
				question.setMaMucDo((int)cellMucdo.getNumericCellValue());
				/* get c�u h??i */
//				Cell cellQuestion = cellIterator.next();
//				question.setQuestion(cellQuestion+"");
//				System.out.println("c�u h??i l�:" + cellQuestion);
				
				
				/*add c�u h??i v�o database
				 */
				
//				idCurrentQus=QuestionService.returnIdQuestionAfterInsert(question);
//				
//				if(idCurrentQus==-1)
//				{
//					return false;
//				}
//				question.setQuestionId(idCurrentQus);
				/* import c�u tr? l??i */
//				while (cellIterator.hasNext()) {
//					answer=new Answer();
//					Cell nextCell = cellIterator.next();
//					Workbook book = currentRow.getSheet().getWorkbook();
//					CellStyle style = nextCell.getCellStyle();
//					int fontIndex = style.getFontIndex();
//					Font font = book.getFontAt(fontIndex);
//					
//					/*them noi dung*/
//					answer.setAnswer(nextCell+"");
//					answer.setQuestionId(idCurrentQus);
//					
//					
//					if (font.getBold()) {
//						int idAns=AnswerService.returnIdAnsAfterInsert(answer);
//						if(idAns==-1)
//						{
//							System.out.println("cau tra loi bi loi");
//							return false;
//						}
//						question.setCorrectAnswerID(idAns);
//						if(QuestionService.updateQuestion(question))
//							{
//							System.out.println("th�m c�u tl d�ng tc");
//							}
//						else return false;	
//					} else {
//						AnswerService.addAnswers(answer);
//					}
//				}
				//AnswerService.addAnswers(answer);
				CAUHOI_DAO dl=new CAUHOI_DAO("1", "1");
				dl.themCauHoi(question.getNoiDungCauHoi(), question.getMaMucDo(), question.isDapAn_A(), question.isDapAn_B(), question.isDapAn_C(), question.isDapAn_D(), question.getDapAnDung());
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}
}