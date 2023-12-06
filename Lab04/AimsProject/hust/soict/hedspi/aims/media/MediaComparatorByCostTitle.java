/* Student: Nguyen Huu Duc - 20210192
 * Class: 732870 
 */
package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
	public int compare(Media media1, Media media2) {
        return Comparator.comparing(Media::getCost)
                .thenComparing(Media::getTitle)
                .compare(media1, media2);
    }
}