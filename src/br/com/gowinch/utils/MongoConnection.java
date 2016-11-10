package br.com.gowinch.utils;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

private static MongoDatabase database;
	
	
	public synchronized static MongoDatabase getMongoConnection(){
	if(database !=null){
		return database;
	}
	
	MongoCredential credential = MongoCredential.createCredential(
            "gowinch", "gowinch",
            "gowinch".toCharArray());
	MongoClient c = new MongoClient(new ServerAddress("ds147797.mlab.com:47797"), Arrays.asList(credential));
    	database = c.getDatabase("gowinch");
    return database;

	}
	
	public static void main(String[] args) {
		getMongoConnection();
		MongoCollection<Document> collection = database.getCollection("users");
		 FindIterable<Document> docs = collection.find();
		 for (Document document : docs) {
			System.out.println(document);
		}
	}
	
	
	
}
