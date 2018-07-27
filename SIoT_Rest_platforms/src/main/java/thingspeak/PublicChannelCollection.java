
package thingspeak;

import java.util.AbstractCollection;
import java.util.Iterator;


public class PublicChannelCollection extends AbstractCollection<PublicChannel> {

    private final String url = "http://api.thingspeak.com";   
    private final String tag;
    private Integer size;

    /**
     * Create a collection containing all public channels.
     */
    public PublicChannelCollection() {
        tag = null;
    }

    /**
     * Create a collection containing all public channels with the given tag.
     * @param tag Tag.
     */
    public PublicChannelCollection(String tag) {
        this.tag = tag;
    }

    /**
     * Use a server other than thingspeak.com. If you are hosting your own
     * Thingspeak server, set the url of the server here.  
     * @param url eg. http://localhost, http://thingspeak.local:3000, etc.
     */    
    public void setUrl(String url) {
        throw new UnsupportedOperationException("Public API is not implemented in open-source servers.");
    }

    /**
     * Get a PublicChannel iterator, for iterating through the collection.
     * @return Iterator.
     */
    @Override
    public Iterator<PublicChannel> iterator() {
        PublicIterator iterator = new PublicIterator(url, tag);
        size = iterator.size();
        
        System.out.println("size"+size);
        return iterator;
    }
    
    /**
     * Get the number of public channels in this collection.
     * @return Number of channels.
     */
    @Override
    public int size() {
        return size;
    }
            
}
