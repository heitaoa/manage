package com.poly.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import de.innosystec.unrar.Archive;
import de.innosystec.unrar.exception.RarException;
import de.innosystec.unrar.rarfile.FileHeader;

public class UnrarUtil {
	/**
	 * * ��ѹ��rar�ļ� *
	 * 
	 * @param rarFileName
	 * @param extPlace
	 */
	public static boolean decompressionRarFiles(String rarFileName, String extPlace) {
		System.out.println("rarFileName:"+rarFileName);
		System.out.println("extPlace:"+extPlace);
		boolean flag = false;
		Archive archive = null;
		File out = null;
		File file = null;
		File dir = null;
		FileOutputStream os = null;
		FileHeader fh = null;
		String path, dirPath = "";
		try {
			file = new File(rarFileName);
			archive = new Archive(file);
		} catch (RarException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (file != null) {
				file = null;
			}
		}
		if (archive != null) {
			try {
				fh = archive.nextFileHeader();
				while (fh != null) {
					path = (extPlace + fh.getFileNameString().trim()).replaceAll("\\\\", "/");
					int end = path.lastIndexOf("/");
					if (end != -1) {
						dirPath = path.substring(0, end);
					}
					try {
						dir = new File(dirPath);
						if (!dir.exists()) {
							dir.mkdirs();
						}
					} catch (RuntimeException e1) {
						e1.printStackTrace();
					} finally {
						if (dir != null) {
							dir = null;
						}
					}
					if (fh.isDirectory()) {
						fh = archive.nextFileHeader();
						continue;
					}
					out = new File(extPlace + fh.getFileNameString().trim());
					try {
						os = new FileOutputStream(out);
						archive.extractFile(fh, os);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (RarException e) {
						e.printStackTrace();
					} finally {
						if (os != null) {
							try {
								os.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (out != null) {
							out = null;
						}
					}
					fh = archive.nextFileHeader();
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			} finally {
				fh = null;
				if (archive != null) {
					try {
						archive.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			flag = true;
		}
		return flag;
	}

	public static void main(String[] args) {
		String absPath = "D:\\zzz\\test.rar";
		// �ļ�����Ŀ¼
		String toPath = "D:\\zzz\\";
		// �ļ�Ŀ¼
		boolean flag = new UnrarUtil().decompressionRarFiles(absPath, toPath);
		System.out.println("flag ---" + flag);
	}

}