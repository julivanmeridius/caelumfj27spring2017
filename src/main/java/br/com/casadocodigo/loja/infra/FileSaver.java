/**
 * 
 */
package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Class responsible for controlling the File Saving process
 * 
 * @author 	Julivan Meridius
 * @since	05/07/2017
 */
@Component //--Fazendo com que o bean registrado no Spring possa ser utilizado em qualquer bean
public class FileSaver {

	public String write(String baseFolder, MultipartFile file){
		String homePath = System.getProperty("user.home");
		String baseFolderPath = homePath + "/" + baseFolder;
		String filePath = baseFolderPath + "/" + file.getOriginalFilename();
		try {
			file.transferTo(new File(filePath));
			return filePath;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
