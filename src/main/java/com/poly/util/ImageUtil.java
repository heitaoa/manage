package com.poly.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtil {

	private static final int WIDTH = 105; // ����ͼ���
	private static final int HEIGHT = 73;// ����ͼ�߶�

	// public static void main(String[] args) {
	// zoomToIcon("d:/a.jpg", 105, 73);
	// }

	// ������û��ѽ
//	public static String zoomToIcon(String sourceImg, int width, int height) { // ��Ŀ��ͼƬ��С��256*256������
//		File sourceFile = new File(sourceImg); // ��sourceFileȡ��ͼƬ����
//		return zoomToIcon(sourceFile, width, height);
//	}

	//
	public static String zoomToIcon(File sourceFile, int width, int height) { // ��Ŀ��ͼƬ��С��256*256������

		String sourceName = sourceFile.getName();
		// תСд
		sourceName = sourceName.toLowerCase();

		String outName = sourceName.substring(0, sourceName.lastIndexOf(".")) + "_" + width + "x" + height + ".jpg";

		String outFilePath = sourceFile.getParent() + "/" + outName;
		try {
			ImageHepler.saveImageAsJpg(sourceFile.getPath(), outFilePath, width, height, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outName;
	}

	// // 20141216
	// public static String zoomToIcon(File sourceFile, int width, int height) {
	// // ��Ŀ��ͼƬ��С��256*256������
	//
	// if (width == 0 || height == 0) {
	// width = WIDTH;
	// height = HEIGHT;
	// }
	// String sourceName = sourceFile.getName();
	// // תСд
	// sourceName = sourceName.toLowerCase();
	// System.out.println("zoomToIcon:" + sourceName);
	// try {
	// BufferedImage iconBI = new BufferedImage(width, height,
	// BufferedImage.TYPE_INT_BGR);
	// Graphics2D g = (Graphics2D) iconBI.getGraphics();
	// BufferedImage sourceBI = ImageIO.read(sourceFile);
	// g.drawImage(sourceBI, 0, 0, width, height, null); // ��ͼ
	// g.dispose();
	// iconBI.flush();
	//
	// File iconDir = new File(sourceFile.getParent()); // ��Ŀ¼������С��Ĺؼ�ͼ
	// if (!iconDir.exists()) {
	// iconDir.mkdirs();
	// }
	// // icon������
	// String iconName = sourceFile.getParent() + "/" + sourceName.substring(0,
	// sourceName.lastIndexOf("."));
	// iconName += "_" + width + "x" + height + ".jpg";
	// File saveFile = new File(iconName);
	// ImageIO.write(iconBI, "jpg", saveFile);
	// return saveFile.getName();
	// } catch (Exception ex) {
	// // ex.printStackTrace();
	// }
	// return null;
	// }

	public static BufferedImage zoom(String srcFileName) {
		// ʹ��Դͼ���ļ�������ImageIcon����
		ImageIcon imgIcon = new ImageIcon(srcFileName);
		// �õ�Image����
		Image img = imgIcon.getImage();
		return zoom(img);
	}

	public static BufferedImage zoom(Image srcImage) {
		// ����һ��Ԥ�����ͼ�����͵�BufferedImage����
		BufferedImage buffImg = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		// buffImg.flush();
		// ����Graphics2D����������BufferedImage�����ϻ�ͼ��
		Graphics g = buffImg.getGraphics();
		// ����ͼ�������ĵĵ�ǰ��ɫΪ��ɫ��
		g.setColor(Color.WHITE);
		// ��ͼ�������ĵĵ�ǰ��ɫ���ָ���ľ�������
		g.fillRect(0, 0, WIDTH, HEIGHT);
		// �������ŵĴ�С��BufferedImage�����ϻ���ԭʼͼ��
		g.drawImage(srcImage, 0, 0, WIDTH, HEIGHT, null);
		// �ͷ�ͼ��������ʹ�õ�ϵͳ��Դ��
		g.dispose();
		// ˢ�´� Image ��������ʹ�õ����п��ع�����Դ.
		srcImage.flush();
		return buffImg;
	}

	/**
	 * �ж��ļ��Ƿ�ΪͼƬ<br>
	 * <br>
	 * 
	 * @param pInput
	 *            �ļ���<br>
	 * @param pImgeFlag
	 *            �жϾ����ļ�����<br>
	 * @return ����Ľ��<br>
	 * @throws Exception
	 */
	public static boolean isPicture(String pInput, String pImgeFlag) {
		// �ļ�����Ϊ�յĳ���
		if (pInput == null || pInput.trim().equals("")) {
			// ���ز��ͺϷ�
			return false;
		}
		// ����ļ���׺��
		String tmpName = pInput.substring(pInput.lastIndexOf(".") + 1, pInput.length());
		// ����ͼƬ��׺������
		String imgeArray[][] = { { "bmp", "0" }, { "dib", "1" }, { "gif", "2" }, { "jfif", "3" }, { "jpe", "4" }, { "jpeg", "5" }, { "jpg", "6" }, { "png", "7" }, { "tif", "8" }, { "tiff", "9" },
				{ "ico", "10" } };
		// ������������
		for (int i = 0; i < imgeArray.length; i++) {
			// �жϵ��������ļ��ĳ���
			if (pImgeFlag != null && imgeArray[i][0].equals(tmpName.toLowerCase()) && imgeArray[i][1].equals(pImgeFlag)) {
				return true;
			}
			// �жϷ���ȫ�����͵ĳ���
			if (pImgeFlag == null && imgeArray[i][0].equals(tmpName.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	/*
	 * public final static String getPressImgPath() { return ApplicationContext
	 * .getRealPath("/template/data/util/shuiyin.gif"); }
	 */

	/**
	 * ��ͼƬӡˢ��ͼƬ��
	 * 
	 * @param pressImg
	 *            -- ˮӡ�ļ�
	 * @param targetImg
	 *            -- Ŀ���ļ�
	 * @param x
	 *            --x����
	 * @param y
	 *            --y����
	 */
	public final static void pressImage(String pressImg, String targetImg, int x, int y) {
		try {
			// Ŀ���ļ�
			File _file = new File(targetImg);
			Image src = ImageIO.read(_file);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);

			// ˮӡ�ļ�
			File _filebiao = new File(pressImg);
			Image src_biao = ImageIO.read(_filebiao);
			int wideth_biao = src_biao.getWidth(null);
			int height_biao = src_biao.getHeight(null);
			if (x == 0)
				x = (wideth - wideth_biao) / 2;
			if (y == 0)
				y = (height - height_biao) / 2;
			g.drawImage(src_biao, x, y, wideth_biao, height_biao, null);
			// ˮӡ�ļ�����
			g.dispose();
			FileOutputStream out = new FileOutputStream(targetImg);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(image);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ӡ����ˮӡͼƬ
	 * 
	 * @param pressText
	 *            --����
	 * @param targetImg
	 *            -- Ŀ��ͼƬ
	 * @param fontName
	 *            -- ������
	 * @param fontStyle
	 *            -- ������ʽ
	 * @param color
	 *            -- ������ɫ
	 * @param fontSize
	 *            -- �����С
	 * @param x
	 *            -- ƫ����
	 * @param y
	 */

	public static void pressText(String pressText, String targetImg, String fontName, int fontStyle, Color color, int fontSize, int x, int y) {
		try {
			File _file = new File(targetImg);
			Image src = ImageIO.read(_file);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);
			// String s="www.qhd.com.cn";
			g.setColor(color);
			g.setFont(new Font(fontName, fontStyle, fontSize));
			g.drawString(pressText, wideth - fontSize - x, height - fontSize / 2 - y);
			g.dispose();
			FileOutputStream out = new FileOutputStream(targetImg);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(image);
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * ��ͼƬ���ˮӡ
	 * 
	 * @param filePath
	 *            ��Ҫ���ˮӡ��ͼƬ��·��
	 * @param markContent
	 *            ˮӡ������
	 * @param markContentColor
	 *            ˮӡ���ֵ���ɫ
	 * @param qualNum
	 *            ͼƬ����
	 * @return
	 */
	public boolean pressText(String filePath, String markContent, Color markContentColor, float qualNum) {
		ImageIcon imgIcon = new ImageIcon(filePath);
		Image theImg = imgIcon.getImage();
		int width = theImg.getWidth(null);
		int height = theImg.getHeight(null);
		BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bimage.createGraphics();
		g.setColor(markContentColor);
		g.setBackground(Color.white);
		g.drawImage(theImg, 0, 0, null);
		g.drawString(markContent, width / 5, height / 5); // ���ˮӡ�����ֺ�����ˮӡ���ֳ��ֵ�����
		g.dispose();
		try {
			FileOutputStream out = new FileOutputStream(filePath);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bimage);
			param.setQuality(qualNum, true);
			encoder.encode(bimage, param);
			out.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// www.chetuan.com
	public static void pressTextForCT(String imgPath) {
		pressText("www.chetuan.com", imgPath, "Arial", 0, Color.gray, 14, 120, 80);
	}

	public static void main(String[] args) {
		File file = new File("D:/zzz/a.jpg");
		System.out.println(file.getPath());

		// pressImage("F:/logo.png", "F:/123.jpg", 0, 0);

		// pressText("www.chetuan.com", "D:/zzz/hero.jpg", "Arial", 0,
		// Color.gray, 14, 120, 80);
	}
}