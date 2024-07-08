package com.org.dao;

import java.util.List;

import javax.persistence.*;

import com.org.dto.Notes;
import com.org.dto.User;

public class NotesDao {
	static	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Fani");  
	static  EntityManager eManager =entityManagerFactory.createEntityManager();
	static	EntityTransaction entityTransaction=eManager.getTransaction();  

	
	public static Notes fetchNoteById(int id) {
		 Notes notes = eManager.find(Notes.class, id);
		 System.out.println(notes.getDescription());
		 return notes;

		}

	
	public static void deleteNotesById(int id)
	{
		Notes notes = eManager.find(Notes.class, id);
		
		User user = notes.getUser();
		
		List<Notes> list = user.getNotes();
		
		for(Notes n : list)
		{
			if(n.getId() == id)
			{
				list.remove(n);
				break;
			}
		}
		entityTransaction.begin();
		eManager.merge(user);
		eManager.remove(notes);
		entityTransaction.commit();
	}
	public static List<Notes> fetchNotesByUserId(int id){
		
		Query query = eManager.createQuery("SELECT s FROM Notes s WHERE user_id=?1");
		query.setParameter(1, id);
		List<Notes> list = query.getResultList();
		return list;
	}
}
