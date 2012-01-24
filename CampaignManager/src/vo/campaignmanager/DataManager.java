package vo.campaignmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

import vo.campaignmanager.core.CCharacter;
import vo.campaignmanager.core.CEvent;
import vo.campaignmanager.core.CPlace;
import vo.campaignmanager.core.CScene;
import vo.campaignmanager.core.Campaign;
import vo.util.UtilCollection;

public class DataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static DataManager instance = new DataManager();
	
	private Campaign 									_chronique;
	private SortedMap<Integer,CScene> 					_sceneMap = new TreeMap<Integer,CScene>();
	private SortedMap<Integer,CCharacter>				_characterMap = new TreeMap<Integer,CCharacter>();
	private SortedMap<Integer,CPlace>					_placeMap = new TreeMap<Integer,CPlace>();
	private SortedMap<Integer,CEvent>					_eventMap = new TreeMap<Integer,CEvent>();
	
	static private List<DataManagerListener>			_listenerList = new ArrayList<DataManager.DataManagerListener>();
	
	
	public static void saveFull(){
		

		ObjectOutputStream oos = null; 
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("./Chronique.txt"));
			oos.writeObject(DataManager.instance);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void loadFull(){
		
		ObjectInputStream oos = null; 
		
		try {
			oos = new ObjectInputStream(new FileInputStream("./Chronique.txt"));
			instance = (DataManager)oos.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		fireDataChange();	
	}
	
	public static DataManager getInstance() {
		return instance;
	}
	
	public void load(String cName) {
		
		_chronique.setName(cName);
		
		load();
		
		
	}
	
	public void load(){
	
		File root = new File(".");
		
		for (String chronique : root.list())
		{
			if (chronique.equals(_chronique.getName())){
				loadCampaign(root.getPath() + "/" + _chronique.getName());
				fireDataChange();
				return;
			}	
		}
	}




	
	public int addCharacter(CCharacter current) {
		if (current.id == -1) {
			if (_characterMap.isEmpty()){
				current.id = 0;
			} else {
			current.id = _characterMap.lastKey()+1;
			}
		}
		_characterMap.put(current.id, current);
		fireDataChange();
		return current.id;
	}

	public int addPlace(CPlace current) {
		if (current.id == -1) {
			if (_placeMap.isEmpty()){
				current.id = 0;
			} else {
			current.id = _placeMap.lastKey()+1;
			}
		}
		_placeMap.put(current.id, current);
		fireDataChange();
		return current.id;	
	}

	public int[] getCharacterListPosition(int[] array) {

		List<Integer> chaList  = new ArrayList<Integer>();
		chaList.addAll(_characterMap.keySet());
		int[] result = new int[array.length];
		
		for (int i = 0;i<chaList.size();i++){
			
		}
		
		
		for ( Object o : array){
			
			
		}
		return result;
	}
	
	public int addScene(CScene current) {
		if (current.id == -1) {
			if (_sceneMap.isEmpty()){
				current.id = 0;
			} else {
			current.id = _sceneMap.lastKey()+1;
			}
		}
		_sceneMap.put(current.id, current);
		fireDataChange();
		return current.id;	
	}
	
	public void addListener(DataManagerListener dml){
		_listenerList.add(dml);
	}

	public Campaign getCampaign() {
		return _chronique;
	}
	
	public void setCampaign(Campaign current) {
		_chronique = current;
		fireDataChange();
	}

	public Collection<CCharacter> getCharacters() {
		
		return _characterMap.values();
	}
	
	public Collection<CPlace> getPlaces() {
		return _placeMap.values();
	}
	

	public Collection<CScene> getScenes() {
		return _sceneMap.values();
	}
	
	private static void fireDataChange(){
		
		for (DataManagerListener dml : _listenerList){
			dml.onDataChanged();
		}
	}
	

	private void loadCampaign(String path) {
		
		File[] childs = new File(path + "/Event").listFiles();
		
		for (File f : childs){
			loadEvent(f);
		}
		
		childs = new File(path + "/Character").listFiles();
		
		for (File f : childs){
			loadCharacter(f);
		}

		childs = new File(path + "/Place").listFiles();
		
		for (File f : childs){
			loadPlace(f);
		}
		
		childs = new File(path + "/Scene").listFiles();
		
		for (File f : childs){
			loadScene(f);
		}
		
		
		
	}

	private void loadPlace(File f) {
		
		ObjectInputStream ois = null; 
		
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			Object obj = ois.readObject();
			if (obj instanceof CPlace){
				CPlace place = (CPlace)obj;
				_placeMap.put(place.id,place);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void loadCharacter(File f) {
		
ObjectInputStream ois = null; 
		
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			Object obj = ois.readObject();
			if (obj instanceof CCharacter){
				CCharacter cha = (CCharacter)obj;
				_characterMap.put(cha.id,cha);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void loadEvent(File f) {
		
		ObjectInputStream ois = null; 
		
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			Object obj = ois.readObject();
			if (obj.getClass().equals(CEvent.class)){
				CEvent e = (CEvent)obj;
				_eventMap.put(e.id,e);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void loadScene(File f) {
		
		ObjectInputStream ois = null; 
		
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			Object obj = ois.readObject();
			if (obj instanceof CScene){
				CScene scene = (CScene)obj;
				_sceneMap.put(scene.id,scene);
			}		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public interface DataManagerListener{
		
		void onDataChanged();
		// void OnCharacterChanged();
		// void OnPlaceChanged();
		// void OnEventChanged();
		// void OnSceneChanged();
		
	}

	public int[] getCharacterIndices(Set<Integer> people) {
		
		return UtilCollection.getIndices((SortedSet<Integer>) _characterMap.keySet(), people);
	}

	public int[] getPlaceIndices(Set<Integer> places) {
		
		return UtilCollection.getIndices((SortedSet<Integer>) _placeMap.keySet(), places);
	}

	public int[] getEventIndices(Set<Integer> events) {
		
		return UtilCollection.getIndices((SortedSet<Integer>) _eventMap.keySet(), events);
	}

	public int[] getSceneIndices(Set<Integer> scenes) {
		
		return UtilCollection.getIndices((SortedSet<Integer>) _sceneMap.keySet(), scenes);
	}

	public CScene getScene(int sceneID) {
		
		return _sceneMap.get(sceneID);
		
	}

	public CPlace getPlace(int placeID) {
		return _placeMap.get(placeID);
	}

	public void clear() {
		
		_eventMap.clear();
		_characterMap.clear();
		_placeMap.clear();
		_sceneMap.clear();
		fireDataChange();
		
	}
	
}
