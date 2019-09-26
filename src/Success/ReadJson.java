package Success;

import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ReadJson {
	public List<ArrayObject> read(String path) {
		List<ArrayObject> objects = new ArrayList<>();
		JsonParser parse =new JsonParser();  //����JSON������
		try {
            JsonObject json=(JsonObject) parse.parse(new FileReader(path));  //����jsonObject����
            JsonArray array = json.get("Oberon").getAsJsonArray(); //��ȡJSON����
            for(int i=0;i<array.size();i++) {
            	ArrayObject obj = new ArrayObject();//��������
            	JsonObject subobject = array.get(i).getAsJsonObject();
            	obj.setNAME(subobject.get("NAME").getAsString());
                obj.setSPA_IP(subobject.get("SPA_IP").getAsString());
                obj.setSPB_IP(subobject.get("SPB_IP").getAsString());
                obj.setBMCA_IP(subobject.get("BMCA_IP").getAsString());
                obj.setBMCA_IP(subobject.get("BMCB_IP").getAsString());
                obj.setDATE(subobject.get("DATE").getAsString());
                obj.setOWNER(subobject.get("OWNER").getAsString());
                obj.setMODE(subobject.get("MODE").getAsString());
                objects.add(obj);
            }
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		return objects;
	}
}

