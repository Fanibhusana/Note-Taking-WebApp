package com.org.dao;

import java.util.List;

import javax.persistence.*;

import com.org.dto.Notes;
import com.org.dto.User;

public class NotesDao {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Fani");  
	    EntityManager eManager =entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=eManager.getTransaction();  

	
	public  Notes fetchNoteById(int id) {
		 Notes notes = eManager.find(Notes.class, id);
		 System.out.println(notes.getDescription());
		 return notes;

		}

	
	public  void deleteNotesById(int id)
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
	public  List<Notes> fetchNotesByUserId(int id){
		
		Query query = eManager.createQuery("SELECT s FROM Notes s WHERE user_id=?1");
		query.setParameter(1, id);
		List<Notes> list = query.getResultList();
		return list;
	}
}
