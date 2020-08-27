using System;
using System.IO;
using System.Linq.Expressions;
using System.Xml.Serialization;
using MetaLinq.Expressions;

class SampleSerialisations {

    static void Deserialize (string xml) {
        //Console.WriteLine (xml);
        var sr = new StringReader (xml);
        var serializer = new XmlSerializer (typeof(EditableLambdaExpression));
        var edexp = serializer.Deserialize (sr) as EditableLambdaExpression;
        var exp = edexp.ToExpression () as LambdaExpression;
        if (exp is Expression<Func<int, int>>) {
            var lambda2 = (exp as Expression<Func<int, int>>).Compile ();
            var result = lambda2 (1);
            Console.WriteLine ($"{result}");
        }
        else if (exp is Expression<Func<int>>){
            var lambda2 = (exp as Expression<Func<int>>).Compile ();
            var result = lambda2 ();
            Console.WriteLine ($"{result}");
        }
        else if (exp is Expression<Func<int, int, int>>){
            var lambda2 = (exp as Expression<Func<int, int, int>>).Compile ();
            var result = lambda2 (1,2);
            Console.WriteLine ($"{result}");
        }
        else if (exp is Expression<Func<int, int, int, int>>){
            var lambda2 = (exp as Expression<Func<int, int, int, int>>).Compile ();
            var result = lambda2 (1,2,3);
            Console.WriteLine ($"{result}");
        }
        else{
            Console.WriteLine ("?");
        }
    }

    public static void Main () {
        //var xml = Serialize ();
        string oneBigString = "";
        string line;
        try{
        
        while((line = Console.In.ReadLine()) != null)  
            {                      
                oneBigString += line +"\n";
            }         
        Deserialize (oneBigString);
        }

        catch (IOException e){
            Console.WriteLine("The file could not be read:");
            Console.WriteLine(e.Message);
        }
    }
}