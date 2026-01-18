package com.ps.compositr.one;

public class Client {

	public static void main(String[] args) {
		 File root = createThreeOne();
		 root.ls();
		
	}
	private static File createThreeOne() {
		Directory dir = new Directory("root");
		dir.addFile(new BinaryFile("file1", 20000));
		dir.addFile(new BinaryFile("file2", 2100));
		dir.addFile(new BinaryFile("file3", 20080));
		Directory dir2 = new Directory("Documents");
		dir.addFile(dir2);
		dir2.addFile(new BinaryFile("file4", 500));
		dir2.addFile(new BinaryFile("file5", 700));
		dir2.addFile(new BinaryFile("file6", 900));
		return dir;
	}

}
