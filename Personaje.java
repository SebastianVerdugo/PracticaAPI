package PracticaAPI;

import java.time.OffsetDateTime;

import java.util.Date;
import java.util.List;


public class Personaje{
    private long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Location origin;
    private Location location;
    private String image;
    private List<String> episode;
    private String url;
    private Date created;
    
    public Personaje(long id, String name, String status, String species, String type, String gender, Location origin,
			Location location, String image, List<String> episode, String url, Date created) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.species = species;
		this.type = type;
		this.gender = gender;
		this.origin = origin;
		this.location = location;
		this.image = image;
		this.episode = episode;
		this.url = url;
		this.created = created;
	}
    
    public Personaje(int id, String name, String url)
    {
    	this.id=id;    	
    	this.name=name;
    	this.url=url;
    }
    
    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }

    public String getSpecies() { return species; }
    public void setSpecies(String value) { this.species = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public String getGender() { return gender; }
    public void setGender(String value) { this.gender = value; }

    public Location getOrigin() { return origin; }
    public void setOrigin(Location value) { this.origin = value; }

    public Location getLocation() { return location; }
    public void setLocation(Location value) { this.location = value; }

    public String getImage() { return image; }
    public void setImage(String value) { this.image = value; }

    public List<String> getEpisode() { return episode; }
    public void setEpisode(List<String> value) { this.episode = value; }

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }

    public Date getCreated() { return created; }
    public void setCreated(Date value) { this.created = value; }


	



}
