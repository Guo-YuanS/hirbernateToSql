package Success;

import java.util.List;

public class Testgys10 {
	public static void main(String[] args) {
		ReadJson readJson = new ReadJson();
		List<ArrayObject> oberons = readJson.read("C:\\Users\\gys\\Desktop\\test.json");
		WriteToSql writeToSql = new WriteToSql();
		writeToSql.write(oberons);
	}
}
