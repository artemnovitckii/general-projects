﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System.Xml.Serialization;

// 
// This source code was auto-generated by xsd, Version=4.6.1055.0.
// 


/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "4.6.1055.0")]
[System.SerializableAttribute()]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
[System.Xml.Serialization.XmlTypeAttribute(AnonymousType=true)]
[System.Xml.Serialization.XmlRootAttribute(Namespace="", IsNullable=false)]
public partial class phonebook {
    
    private phonebookEntry[] entryField;
    
    private string ownerField;
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute("entry", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
    public phonebookEntry[] entry {
        get {
            return this.entryField;
        }
        set {
            this.entryField = value;
        }
    }
    
    /// <remarks/>
    [System.Xml.Serialization.XmlAttributeAttribute()]
    public string owner {
        get {
            return this.ownerField;
        }
        set {
            this.ownerField = value;
        }
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "4.6.1055.0")]
[System.SerializableAttribute()]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
[System.Xml.Serialization.XmlTypeAttribute(AnonymousType=true)]
public partial class phonebookEntry {
    
    private string firstnameField;
    
    private string familynameField;
    
    private string[] phoneField;
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
    public string firstname {
        get {
            return this.firstnameField;
        }
        set {
            this.firstnameField = value;
        }
    }
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
    public string familyname {
        get {
            return this.familynameField;
        }
        set {
            this.familynameField = value;
        }
    }
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute("phone", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
    public string[] phone {
        get {
            return this.phoneField;
        }
        set {
            this.phoneField = value;
        }
    }
}