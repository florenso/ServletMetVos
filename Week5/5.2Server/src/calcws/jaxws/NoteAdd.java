
package calcws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "note", namespace = "http://")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "note", namespace = "http://calcws/", propOrder = {
    "text",
	"id",
})

public class NoteAdd {

    @XmlElement(name = "text", namespace = "")
    private String text;
    @XmlElement(name = "id", namespace = "")
    private int id;

    /**
     * 
     * @return
     *     returns int
     */
    public int getText() {
        return this.text;
    }

    /**
     * 
     * @param a
     *     the value for the a property
     */
    public void setText(String t) {
        this.text = t;
    }

    /**
     * 
     * @return
     *     returns int
     */
    public int getId() {
        return this.id;
    }

    /**
     * 
     * @param b
     *     the value for the b property
     */
    public void setId(int i) {
        this.id = i;
    }

}

