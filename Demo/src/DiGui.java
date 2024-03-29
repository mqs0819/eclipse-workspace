import java.io.File;

public class DiGui {
	public static void main(String[] args) 
	{
		String path = "D:\\";
		
		//遍歷該文件夾下的所有文件
		Traverse(path, 0);
	}

	private static void Traverse(String path, int depth) 
	{
		File f = new File(path);
		try {
			if(f.exists())
			{
				File[] fils = f.listFiles();
				for(File fv : fils)
				{
					for (int i = 0; i < depth; i++) {
						System.out.print("\t");
					}
					if(fv.isDirectory()) {
						System.out.println(fv.getName());
						Traverse(fv.getAbsolutePath(), (depth+1));
					}else {
						System.out.println(fv.getName());
					}
				}
			}
		} catch (java.lang.NullPointerException e) {}
	}
}
