package br.com.gowinch.dao;

import java.util.ArrayList;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.gowinch.model.User;
import br.com.gowinch.utils.MongoConnection;

public class UserDAO {

	
	private MongoDatabase database;
	private MongoCollection<Document> userCollection;
	
	public ArrayList<User> getAllUsers(){
			ArrayList<User> users = new ArrayList<User>();
		database = MongoConnection.getMongoConnection();
		userCollection = database.getCollection("users");
		
		FindIterable<Document> foundUsers = userCollection.find();
		
		for (Document document : foundUsers) {
			Gson gson = new Gson();
			User u = gson.fromJson(document.toJson(), User.class);
			//System.out.println(u.getUsername());
			users.add(u);
		}
	
		
		return users;
	}
	
	
}
