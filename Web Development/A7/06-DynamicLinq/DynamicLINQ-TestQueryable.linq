<Query Kind="Program">
  <Connection>
    <ID>ed848c4b-43a3-43cf-a9c9-1db367b53a44</ID>
    <Server>(LocalDB)\MSSQLLocalDB</Server>
    <AttachFile>true</AttachFile>
    <AttachFileName>C:\usertmp\Northwind.mdf</AttachFileName>
  </Connection>
  <Reference>DynamicLinqUoA.dll</Reference>
  <Namespace>System.Linq.Dynamic</Namespace>
</Query>

void Main() {
    MyOrders .Dump ("MyOrders");
    
    var w1 = MyOrders .Where (o => o.Price > 20);
    w1 .Dump ("w1");
    
    var w2 = MyOrders .Where ("Price > 20"); 
    w2 .Dump ("w2");

    var a1 = MyOrders .OrderBy (o => o.Price) .ThenBy (o => o.OrderID);
    a1 .Dump ("a1");
    
    var a2 = MyOrders .OrderBy ("Price, OrderID");
    a2 .Dump ("a2");
    
    var d1 = MyOrders .OrderByDescending (o => o.Price) .ThenByDescending (o => o.OrderID);
    d1 .Dump ("d1");
    
    var d2 = MyOrders .OrderBy ("Price DESC, OrderID DESC");
    d2 .Dump ("d2");
}