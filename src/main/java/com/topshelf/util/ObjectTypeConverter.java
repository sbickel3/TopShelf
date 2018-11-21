package com.topshelf.util;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

import org.json.JSONArray;
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
	
	
	
	public static ArrayList<Ingredient> convertBlobToList(Blob blob) throws SQLException, JSONException {
		//Log4j log = new Log4j(); 
		
		JSONObject bigJson = convertBLOBtoJSON(blob);
		if (bigJson.isNull("ingredient")) {
			return new ArrayList<Ingredient>();
		}
		
		ArrayList<Ingredient> list = new ArrayList<>();
		//Iterator<String> bigKeys = bigJson.keys(); 
		
		JSONArray jsonArray = bigJson.getJSONArray("ingredient");
		
		//log.LOGGER.debug(jsonArray);
		
		for(int i=0; i<jsonArray.length(); i++) {
			
			JSONObject json = jsonArray.getJSONObject(i);
			
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
					ingr.setIngredient(value);
					break;
				}
			}
			
		//	log.LOGGER.debug(ingr);
			list.add(ingr);
		}
		//log.LOGGER.debug(list);
		return list;
	}
	
	
	
	public static JSONObject convertListToJson(ArrayList<Ingredient> ingredients) throws JSONException {
		//Log4j log = new Log4j(); 
		
		if (ingredients == null) {
			return new JSONObject();
		}

		JSONArray jsonArray = new JSONArray();
		for (Ingredient ingred: ingredients) {
			//String key = ingred.getIngredientName();
			JSONObject littleJson = new JSONObject();
			littleJson.put("quantity", ingred.getQuantity());
			littleJson.put("unit", ingred.getUnit());
			littleJson.put("ingredient", ingred.getIngredient());
			//bigJson.put(key, littleJson);
			
		//	log.LOGGER.debug(littleJson);

			jsonArray.put(littleJson);
			
		}
		//log.LOGGER.debug(jsonArray);
		JSONObject bigJson = new JSONObject();
		bigJson.put("ingredient", jsonArray);
		//log.LOGGER.debug(bigJson);
		return bigJson;
	}

}
