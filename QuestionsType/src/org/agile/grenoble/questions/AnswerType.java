/*
 * XML Type:  answerType
 * Namespace: http://grenoble.agile.org/questions
 * Java type: org.agile.grenoble.questions.AnswerType
 *
 * Automatically generated - do not modify.
 */
package org.agile.grenoble.questions;


/**
 * An XML answerType(@http://grenoble.agile.org/questions).
 *
 * This is a complex type.
 */
public interface AnswerType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AnswerType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s32A2924D89A49183F5DC8C9EA3267D67").resolveHandle("answertype5935type");
    
    /**
     * Gets the "label" element
     */
    java.lang.String getLabel();
    
    /**
     * Gets (as xml) the "label" element
     */
    org.apache.xmlbeans.XmlString xgetLabel();
    
    /**
     * Sets the "label" element
     */
    void setLabel(java.lang.String label);
    
    /**
     * Sets (as xml) the "label" element
     */
    void xsetLabel(org.apache.xmlbeans.XmlString label);
    
    /**
     * Gets the "point" element
     */
    java.lang.String getPoint();
    
    /**
     * Gets (as xml) the "point" element
     */
    org.apache.xmlbeans.XmlString xgetPoint();
    
    /**
     * True if has "point" element
     */
    boolean isSetPoint();
    
    /**
     * Sets the "point" element
     */
    void setPoint(java.lang.String point);
    
    /**
     * Sets (as xml) the "point" element
     */
    void xsetPoint(org.apache.xmlbeans.XmlString point);
    
    /**
     * Unsets the "point" element
     */
    void unsetPoint();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.agile.grenoble.questions.AnswerType newInstance() {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.agile.grenoble.questions.AnswerType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.agile.grenoble.questions.AnswerType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.agile.grenoble.questions.AnswerType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.agile.grenoble.questions.AnswerType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.agile.grenoble.questions.AnswerType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.agile.grenoble.questions.AnswerType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.agile.grenoble.questions.AnswerType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.agile.grenoble.questions.AnswerType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.agile.grenoble.questions.AnswerType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.agile.grenoble.questions.AnswerType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.agile.grenoble.questions.AnswerType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.agile.grenoble.questions.AnswerType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.agile.grenoble.questions.AnswerType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.agile.grenoble.questions.AnswerType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.agile.grenoble.questions.AnswerType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.agile.grenoble.questions.AnswerType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.agile.grenoble.questions.AnswerType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.agile.grenoble.questions.AnswerType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
