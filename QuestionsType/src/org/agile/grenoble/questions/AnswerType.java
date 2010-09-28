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
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AnswerType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE5824B5D8561689F60EFBB22B530B038").resolveHandle("answertype5935type");
    
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
     * Gets the "selected" element
     */
    org.agile.grenoble.questions.AnswerType.Selected.Enum getSelected();
    
    /**
     * Gets (as xml) the "selected" element
     */
    org.agile.grenoble.questions.AnswerType.Selected xgetSelected();
    
    /**
     * True if has "selected" element
     */
    boolean isSetSelected();
    
    /**
     * Sets the "selected" element
     */
    void setSelected(org.agile.grenoble.questions.AnswerType.Selected.Enum selected);
    
    /**
     * Sets (as xml) the "selected" element
     */
    void xsetSelected(org.agile.grenoble.questions.AnswerType.Selected selected);
    
    /**
     * Unsets the "selected" element
     */
    void unsetSelected();
    
    /**
     * An XML selected(@http://grenoble.agile.org/questions).
     *
     * This is an atomic type that is a restriction of org.agile.grenoble.questions.AnswerType$Selected.
     */
    public interface Selected extends org.apache.xmlbeans.XmlString
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Selected.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE5824B5D8561689F60EFBB22B530B038").resolveHandle("selected86deelemtype");
        
        org.apache.xmlbeans.StringEnumAbstractBase enumValue();
        void set(org.apache.xmlbeans.StringEnumAbstractBase e);
        
        static final Enum TRUE = Enum.forString("true");
        static final Enum FALSE = Enum.forString("false");
        
        static final int INT_TRUE = Enum.INT_TRUE;
        static final int INT_FALSE = Enum.INT_FALSE;
        
        /**
         * Enumeration value class for org.agile.grenoble.questions.AnswerType$Selected.
         * These enum values can be used as follows:
         * <pre>
         * enum.toString(); // returns the string value of the enum
         * enum.intValue(); // returns an int value, useful for switches
         * // e.g., case Enum.INT_TRUE
         * Enum.forString(s); // returns the enum value for a string
         * Enum.forInt(i); // returns the enum value for an int
         * </pre>
         * Enumeration objects are immutable singleton objects that
         * can be compared using == object equality. They have no
         * public constructor. See the constants defined within this
         * class for all the valid values.
         */
        static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase
        {
            /**
             * Returns the enum value for a string, or null if none.
             */
            public static Enum forString(java.lang.String s)
                { return (Enum)table.forString(s); }
            /**
             * Returns the enum value corresponding to an int, or null if none.
             */
            public static Enum forInt(int i)
                { return (Enum)table.forInt(i); }
            
            private Enum(java.lang.String s, int i)
                { super(s, i); }
            
            static final int INT_TRUE = 1;
            static final int INT_FALSE = 2;
            
            public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
                new org.apache.xmlbeans.StringEnumAbstractBase.Table
            (
                new Enum[]
                {
                    new Enum("true", INT_TRUE),
                    new Enum("false", INT_FALSE),
                }
            );
            private static final long serialVersionUID = 1L;
            private java.lang.Object readResolve() { return forInt(intValue()); } 
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.agile.grenoble.questions.AnswerType.Selected newValue(java.lang.Object obj) {
              return (org.agile.grenoble.questions.AnswerType.Selected) type.newValue( obj ); }
            
            public static org.agile.grenoble.questions.AnswerType.Selected newInstance() {
              return (org.agile.grenoble.questions.AnswerType.Selected) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.agile.grenoble.questions.AnswerType.Selected newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.agile.grenoble.questions.AnswerType.Selected) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
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
