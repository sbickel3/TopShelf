package com.topshelf.util;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

import org.json.JSONException;
import org.json.JSONObject;

public class ObjectTypeConverter {

	// convert a JSON object into a Blob object
	public static Blob convertJSONtoBLOB(JSONObject json) throws SerialException, SQLException, UnsupportedEncodingException {
		byte[] jsonAsBytes = json.toString().getBytes("UTF-8");
		Blob blob = new SerialBlob(jsonAsBytes);
		return blob;
	}

	// convert a Blob object into a JSON object
	public static JSONObject convertBLOBtoJSON(Blob blob) throws SQLException, JSONException {
		byte[] blobAsBytes = blob.getBytes(1, (int) blob.length());
		JSONObject json = new JSONObject(new String(blobAsBytes));
		return json;
	}
	
	// convert a JSON object into a Clob object
	public static Clob convertJSONtoCLOB(JSONObject json) throws SerialException, SQLException, UnsupportedEncodingException {
		char[] jsonAsChar = json.toString().toCharArray();
		Clob clob = new SerialClob(jsonAsChar);
		return clob;
	}
	
	// convert a Clob object into a JSON object
//	public static JSONObject convertCLOBtoJSON(Clob clob) throws SQLException, JSONException {
//		char[] clobAsChar = clob.
//		byte[] blobAsBytes = clob.getBytes(1, (int) blob.length());
//		JSONObject json = new JSONObject(new String(blobAsBytes));
//		return json;
//	}
	
	// convert a Blob To Byte Array
	public static byte[] convertBlobToByteArray(Blob blob) throws SQLException, JSONException {
		byte[] blobAsBytes = blob.getBytes(1, (int) blob.length());
		return blobAsBytes;
	}
	
	
	public static HashMap<String,Integer> convertBlobToHashMap(Blob blob) throws SQLException, JSONException{
		JSONObject json = convertBLOBtoJSON(blob);
		
		HashMap<String, Integer> map = new HashMap<>();
		Iterator<String> keys = json.keys();
		while(keys.hasNext()) {
			String key = (String) keys.next();
			map.put(key, (Integer) json.get(key));
		}
		return map;
	}
	
	public static List<Ingredient> convertBlobToList(Blob blob) throws SQLException, JSONException {
		JSONObject bigJson = convertBLOBtoJSON(blob);
		
		List<Ingredient> list = new ArrayList<>();
		Iterator<String> bigKeys = bigJson.keys(); 
		while(bigKeys.hasNext()) {
			String key = (String) bigKeys.next();
			JSONObject json = (JSONObject) bigJson.get(key);
			
			Iterator<String> littleKeys = json.keys();
			Ingredient ingr = new Ingredient();
			while(littleKeys.hasNext()) {
				String miniKey = (String) littleKeys.next();
				String value = (String) json.get(miniKey);
				switch(miniKey) {
				case "quantity":
					ingr.setQuantity(value);
					break;
				case "unit":
					ingr.setUnit(value);
					break;
				case "ingredient":
					ingr.setIngredientName(value);
					break;
				}
			}
			list.add(ingr);
		}
		
		return list;
		
	}

}
