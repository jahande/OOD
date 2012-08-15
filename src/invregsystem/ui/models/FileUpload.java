package invregsystem.ui.models;

import java.io.File;

import utilities.FileUtil;

public class FileUpload {
	private static FileUpload instance;

	private FileUpload() {
	}

	public static FileUpload getInstance() {
		if (instance == null) {
			instance = new FileUpload();
		}
		return instance;
	}

	public String copyToFilesDirectory(String srcFile) {
		/**
		 * Copy srcFile files directory of application. If there exists a file
		 * with the same name, rename the new File.
		 */
		String destFile = "files\\" + FileUtil.getFileNameByPath(srcFile);
		String newDestFile = getNewDestFile(destFile);
		System.out.println("newDtFile = " + newDestFile);

		FileUtil.copyFile(srcFile, newDestFile);
		return newDestFile;
	}

	private String getNewDestFile(String file) {
		String newFile = file;
		int lastDotIndex = file.lastIndexOf('.');
		int suffix = 1;
		while (new File(newFile).exists()) {
			if (lastDotIndex != -1) {
				newFile = file.substring(0, lastDotIndex) + "_" + suffix + file.substring(lastDotIndex);
			} else {
				newFile = file + "_" + suffix;
			}
			suffix++;
		}
		return newFile;
	}

}
