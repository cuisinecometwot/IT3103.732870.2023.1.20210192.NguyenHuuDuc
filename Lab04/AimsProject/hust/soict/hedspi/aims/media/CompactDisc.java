/* Student: Nguyen Huu Duc - 20210192
 * Class: 732870 
 */
package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> tracks) {
		super(id, title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
	}

	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		for (Track track : tracks) {
			track.play();
		}
	}
	
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
			System.out.println(track+" has been added");
		}
		System.out.println(track+" is already in the track list");
	}
	
	public void removeTrack(Track track) {
		if(!tracks.contains(track)) {
			System.out.println(track+" is not in the track list");
		}
		else{
			tracks.remove(track);
			System.out.println(track+" has been removed from the track list");
		}
	}
	
	public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String toString() {
		return "ID - "+getId()+ ". CD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getArtist() + " - " + getLength() + "s - $" + getCost();
	}
}