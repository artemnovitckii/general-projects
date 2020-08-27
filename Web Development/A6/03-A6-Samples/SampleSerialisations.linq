<Query Kind="Program">
  <Reference>MetaLinqUoA.dll</Reference>
  <Namespace>MetaLinq.Expressions</Namespace>
  <Namespace>System.Xml.Serialization</Namespace>
</Query>

string Serialize () {
	Expression<Func<int, int>> lambda1 = x => (x + 1) * (x + 2);
	Console.WriteLine ($"{lambda1.ToString()}");
	lambda1.Dump ("lambda1");
	
	var exp = lambda1 as Expression;
	var metexp = 
	    MetaLinq.EditableExpression.CreateEditableExpression (exp);
	
	var serializer = new XmlSerializer (typeof(EditableLambdaExpression));
	var sw = new StringWriter ();
	serializer.Serialize (sw, metexp);
	var xml = sw.ToString ();
	return xml;
}

void Deserialize (string xml) {
    xml.Dump ("xml");
	var sr = new StringReader (xml);
	var serializer = new XmlSerializer (typeof(EditableLambdaExpression));
	var metexp = serializer.Deserialize (sr) as EditableLambdaExpression;
	var exp = metexp.ToExpression () as LambdaExpression;
	if (exp is Expression<Func<int, int>>) {
		var lambda2 = (exp as Expression<Func<int, int>>).Compile ();
		var result = lambda2 (1);
		Console.WriteLine ($"{result}");
	}
}

void Main () {
	var xml = Serialize ();
	Deserialize (xml);
}

// ---