package com.measuring.equipment.utility;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

import com.measuring.equipment.common.EquipmentDTO;


public class FileUploadUtility {
	
	public static void uploadProductDetails(MultipartFile file, EquipmentDTO equipmentDTO) {
		try {
			
			byte[] bytes = file.getBytes();	
			Path path = Paths.get("D:\\Start Web\\" + file.getOriginalFilename());
			Files.write(path, bytes);
			equipmentDTO.setEquipmentCalibrationCertificateName(file.getOriginalFilename());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
