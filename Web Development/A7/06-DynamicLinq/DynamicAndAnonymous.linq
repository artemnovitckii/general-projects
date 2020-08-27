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

void Main () {
    var r0 = MyOrders
        .Select (o => 
            new MyO {
                OrderID = o .OrderID, 
                CustomerName = o .MyCustomers.Name,
                Items = o .Items,})
        .OrderBy (x => x .OrderID)
        .Skip (4)
        .Take (2)
        .ToList ();
        
    r0 .Dump ("r0");
    
    // ---
    
    IQueryable <MyO> r1 = MyOrders
        .Select (o => 
            new MyO {
                OrderID = o .OrderID, 
                CustomerName = o .MyCustomers .Name,
                Items = o .Items,})
        .OrderBy (x => x .OrderID);
        
    var r2 = r1
        .Skip (4)
        .Take (2)
        .ToList ();
    
    r2 .Dump ("r2");

    // ---
    
    IQueryable <object> s1 = MyOrders
        .Select (o => 
            new {
                o .OrderID, 
                o .MyCustomers .Name,
                o .Items,})
        .OrderBy (x => x.OrderID);
        
    var s2 = s1
        .Skip (4)
        .Take (2)
        .Select (o => new MyO (o))
        .ToList ();
    
    s2.Dump("s2");
        
    // ---
    
    IQueryable <object> u1 = MyOrders
        .Select ("new (MyCustomers.Name, OrderID, Items)")
        .OrderBy ("OrderID")
        .Cast <object> ();
            
    var u2 = u1
        .Skip (4)
        .Take (2)
        .Select (o => new MyO (o))
        .ToList ();

    u2.Dump ("u2");
}

public class MyO {
    public MyO () {}
    public MyO (object o) {
        dynamic y = o;
        OrderID = y .OrderID;
        CustomerName = y .Name;
        Items = y .Items;
    }
    
    public string OrderID {get; set;}
    public string CustomerName {get; set;}
    public int Items {get; set;}
}