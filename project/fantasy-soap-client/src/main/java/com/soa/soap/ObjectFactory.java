
package com.soa.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soa.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SaveCave_QNAME = new QName("http://soap.soa.com/", "saveCave");
    private final static QName _SaveCaveResponse_QNAME = new QName("http://soap.soa.com/", "saveCaveResponse");
    private final static QName _SaveForest_QNAME = new QName("http://soap.soa.com/", "saveForest");
    private final static QName _SaveForestResponse_QNAME = new QName("http://soap.soa.com/", "saveForestResponse");
    private final static QName _SaveTower_QNAME = new QName("http://soap.soa.com/", "saveTower");
    private final static QName _SaveTowerResponse_QNAME = new QName("http://soap.soa.com/", "saveTowerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soa.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SaveCave }
     * 
     */
    public SaveCave createSaveCave() {
        return new SaveCave();
    }

    /**
     * Create an instance of {@link SaveCaveResponse }
     * 
     */
    public SaveCaveResponse createSaveCaveResponse() {
        return new SaveCaveResponse();
    }

    /**
     * Create an instance of {@link SaveForest }
     * 
     */
    public SaveForest createSaveForest() {
        return new SaveForest();
    }

    /**
     * Create an instance of {@link SaveForestResponse }
     * 
     */
    public SaveForestResponse createSaveForestResponse() {
        return new SaveForestResponse();
    }

    /**
     * Create an instance of {@link SaveTower }
     * 
     */
    public SaveTower createSaveTower() {
        return new SaveTower();
    }

    /**
     * Create an instance of {@link SaveTowerResponse }
     * 
     */
    public SaveTowerResponse createSaveTowerResponse() {
        return new SaveTowerResponse();
    }

    /**
     * Create an instance of {@link Forest }
     * 
     */
    public Forest createForest() {
        return new Forest();
    }

    /**
     * Create an instance of {@link Elf }
     * 
     */
    public Elf createElf() {
        return new Elf();
    }

    /**
     * Create an instance of {@link UserData }
     * 
     */
    public UserData createUserData() {
        return new UserData();
    }

    /**
     * Create an instance of {@link Cave }
     * 
     */
    public Cave createCave() {
        return new Cave();
    }

    /**
     * Create an instance of {@link Dragon }
     * 
     */
    public Dragon createDragon() {
        return new Dragon();
    }

    /**
     * Create an instance of {@link Tower }
     * 
     */
    public Tower createTower() {
        return new Tower();
    }

    /**
     * Create an instance of {@link Mag }
     * 
     */
    public Mag createMag() {
        return new Mag();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCave }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveCave }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "saveCave")
    public JAXBElement<SaveCave> createSaveCave(SaveCave value) {
        return new JAXBElement<SaveCave>(_SaveCave_QNAME, SaveCave.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCaveResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveCaveResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "saveCaveResponse")
    public JAXBElement<SaveCaveResponse> createSaveCaveResponse(SaveCaveResponse value) {
        return new JAXBElement<SaveCaveResponse>(_SaveCaveResponse_QNAME, SaveCaveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveForest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveForest }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "saveForest")
    public JAXBElement<SaveForest> createSaveForest(SaveForest value) {
        return new JAXBElement<SaveForest>(_SaveForest_QNAME, SaveForest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveForestResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveForestResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "saveForestResponse")
    public JAXBElement<SaveForestResponse> createSaveForestResponse(SaveForestResponse value) {
        return new JAXBElement<SaveForestResponse>(_SaveForestResponse_QNAME, SaveForestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveTower }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveTower }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "saveTower")
    public JAXBElement<SaveTower> createSaveTower(SaveTower value) {
        return new JAXBElement<SaveTower>(_SaveTower_QNAME, SaveTower.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveTowerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveTowerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "saveTowerResponse")
    public JAXBElement<SaveTowerResponse> createSaveTowerResponse(SaveTowerResponse value) {
        return new JAXBElement<SaveTowerResponse>(_SaveTowerResponse_QNAME, SaveTowerResponse.class, null, value);
    }

}
