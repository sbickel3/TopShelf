package com.topshelf.util;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;
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

}
