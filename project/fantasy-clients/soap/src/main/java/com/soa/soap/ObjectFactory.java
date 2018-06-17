
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

    private final static QName _ModifyArrows_QNAME = new QName("http://soap.soa.com/", "modifyArrows");
    private final static QName _ModifyArrowsResponse_QNAME = new QName("http://soap.soa.com/", "modifyArrowsResponse");
    private final static QName _ModifyGold_QNAME = new QName("http://soap.soa.com/", "modifyGold");
    private final static QName _ModifyGoldResponse_QNAME = new QName("http://soap.soa.com/", "modifyGoldResponse");
    private final static QName _ModifyMana_QNAME = new QName("http://soap.soa.com/", "modifyMana");
    private final static QName _ModifyManaResponse_QNAME = new QName("http://soap.soa.com/", "modifyManaResponse");
    private final static QName _SaveDragon_QNAME = new QName("http://soap.soa.com/", "saveDragon");
    private final static QName _SaveDragonResponse_QNAME = new QName("http://soap.soa.com/", "saveDragonResponse");
    private final static QName _SaveElf_QNAME = new QName("http://soap.soa.com/", "saveElf");
    private final static QName _SaveElfResponse_QNAME = new QName("http://soap.soa.com/", "saveElfResponse");
    private final static QName _SaveMag_QNAME = new QName("http://soap.soa.com/", "saveMag");
    private final static QName _SaveMagResponse_QNAME = new QName("http://soap.soa.com/", "saveMagResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soa.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ModifyArrows }
     * 
     */
    public ModifyArrows createModifyArrows() {
        return new ModifyArrows();
    }

    /**
     * Create an instance of {@link ModifyArrowsResponse }
     * 
     */
    public ModifyArrowsResponse createModifyArrowsResponse() {
        return new ModifyArrowsResponse();
    }

    /**
     * Create an instance of {@link ModifyGold }
     * 
     */
    public ModifyGold createModifyGold() {
        return new ModifyGold();
    }

    /**
     * Create an instance of {@link ModifyGoldResponse }
     * 
     */
    public ModifyGoldResponse createModifyGoldResponse() {
        return new ModifyGoldResponse();
    }

    /**
     * Create an instance of {@link ModifyMana }
     * 
     */
    public ModifyMana createModifyMana() {
        return new ModifyMana();
    }

    /**
     * Create an instance of {@link ModifyManaResponse }
     * 
     */
    public ModifyManaResponse createModifyManaResponse() {
        return new ModifyManaResponse();
    }

    /**
     * Create an instance of {@link SaveDragon }
     * 
     */
    public SaveDragon createSaveDragon() {
        return new SaveDragon();
    }

    /**
     * Create an instance of {@link SaveDragonResponse }
     * 
     */
    public SaveDragonResponse createSaveDragonResponse() {
        return new SaveDragonResponse();
    }

    /**
     * Create an instance of {@link SaveElf }
     * 
     */
    public SaveElf createSaveElf() {
        return new SaveElf();
    }

    /**
     * Create an instance of {@link SaveElfResponse }
     * 
     */
    public SaveElfResponse createSaveElfResponse() {
        return new SaveElfResponse();
    }

    /**
     * Create an instance of {@link SaveMag }
     * 
     */
    public SaveMag createSaveMag() {
        return new SaveMag();
    }

    /**
     * Create an instance of {@link SaveMagResponse }
     * 
     */
    public SaveMagResponse createSaveMagResponse() {
        return new SaveMagResponse();
    }

    /**
     * Create an instance of {@link WsElf }
     * 
     */
    public WsElf createWsElf() {
        return new WsElf();
    }

    /**
     * Create an instance of {@link WsMag }
     * 
     */
    public WsMag createWsMag() {
        return new WsMag();
    }

    /**
     * Create an instance of {@link WsDragon }
     * 
     */
    public WsDragon createWsDragon() {
        return new WsDragon();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyArrows }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ModifyArrows }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "modifyArrows")
    public JAXBElement<ModifyArrows> createModifyArrows(ModifyArrows value) {
        return new JAXBElement<ModifyArrows>(_ModifyArrows_QNAME, ModifyArrows.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyArrowsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ModifyArrowsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "modifyArrowsResponse")
    public JAXBElement<ModifyArrowsResponse> createModifyArrowsResponse(ModifyArrowsResponse value) {
        return new JAXBElement<ModifyArrowsResponse>(_ModifyArrowsResponse_QNAME, ModifyArrowsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyGold }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ModifyGold }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "modifyGold")
    public JAXBElement<ModifyGold> createModifyGold(ModifyGold value) {
        return new JAXBElement<ModifyGold>(_ModifyGold_QNAME, ModifyGold.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyGoldResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ModifyGoldResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "modifyGoldResponse")
    public JAXBElement<ModifyGoldResponse> createModifyGoldResponse(ModifyGoldResponse value) {
        return new JAXBElement<ModifyGoldResponse>(_ModifyGoldResponse_QNAME, ModifyGoldResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyMana }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ModifyMana }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "modifyMana")
    public JAXBElement<ModifyMana> createModifyMana(ModifyMana value) {
        return new JAXBElement<ModifyMana>(_ModifyMana_QNAME, ModifyMana.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyManaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ModifyManaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "modifyManaResponse")
    public JAXBElement<ModifyManaResponse> createModifyManaResponse(ModifyManaResponse value) {
        return new JAXBElement<ModifyManaResponse>(_ModifyManaResponse_QNAME, ModifyManaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveDragon }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveDragon }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "saveDragon")
    public JAXBElement<SaveDragon> createSaveDragon(SaveDragon value) {
        return new JAXBElement<SaveDragon>(_SaveDragon_QNAME, SaveDragon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveDragonResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveDragonResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "saveDragonResponse")
    public JAXBElement<SaveDragonResponse> createSaveDragonResponse(SaveDragonResponse value) {
        return new JAXBElement<SaveDragonResponse>(_SaveDragonResponse_QNAME, SaveDragonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveElf }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveElf }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "saveElf")
    public JAXBElement<SaveElf> createSaveElf(SaveElf value) {
        return new JAXBElement<SaveElf>(_SaveElf_QNAME, SaveElf.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveElfResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveElfResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "saveElfResponse")
    public JAXBElement<SaveElfResponse> createSaveElfResponse(SaveElfResponse value) {
        return new JAXBElement<SaveElfResponse>(_SaveElfResponse_QNAME, SaveElfResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveMag }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveMag }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "saveMag")
    public JAXBElement<SaveMag> createSaveMag(SaveMag value) {
        return new JAXBElement<SaveMag>(_SaveMag_QNAME, SaveMag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveMagResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveMagResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.com/", name = "saveMagResponse")
    public JAXBElement<SaveMagResponse> createSaveMagResponse(SaveMagResponse value) {
        return new JAXBElement<SaveMagResponse>(_SaveMagResponse_QNAME, SaveMagResponse.class, null, value);
    }

}
