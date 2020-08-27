using System;
using System.IO;
using System.Linq.Expressions;
using System.Xml.Serialization;
using MetaLinq.Expressions;

class SampleSerialisations {
    static string Serialize () {
        Expression<Func<int, int>> lambda1 = x => (x + 1) * (x + 2);
        Console.WriteLine ($"{lambda1.ToString()}");
        // lambda1.Dump ("lambda1"); SORRY, not w/o Linqpad!
        
        var exp = lambda1 as Expression;
        var edexp = 
            MetaLinq.EditableExpression.CreateEditableExpression (exp);
        
        var serializer = new XmlSerializer (typeof(EditableLambdaExpression));
        var sw = new StringWriter ();
        serializer.Serialize (sw, edexp);
        var xml = sw.ToString ();
        return xml;
    }

    static void Deserialize (string xml) {
        Console.WriteLine (xml);
        var sr = new StringReader (xml);
        var serializer = new XmlSerializer (typeof(EditableLambdaExpression));
        var edexp = serializer.Deserialize (sr) as EditableLambdaExpression;
        var exp = edexp.ToExpression () as LambdaExpression;
        if (exp is Expression<Func<int, int>>) {
            var lambda2 = (exp as Expression<Func<int, int>>).Compile ();
            var result = lambda2 (1);
            Console.WriteLine ($"{result}");
        }
    }

    public static void Main () {
        var xml = Serialize ();
        Deserialize (xml);
    }
}

// ---