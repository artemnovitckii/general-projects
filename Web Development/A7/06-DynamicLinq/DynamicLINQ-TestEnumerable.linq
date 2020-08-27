<Query Kind="Program">
  <Reference>DynamicLinqUoA.dll</Reference>
  <Namespace>System.Linq.Dynamic</Namespace>
</Query>

void Main() {
    MyOrders .Dump ("MyOrders");
    
    var w1 = MyOrders .Where (o => o.Price > 20);
    w1.Dump ("w1");
    
    var w2 = MyOrders .AsQueryable () .Where("Price > 20"); 
    w2.Dump("w2");

    var a1 = MyOrders .OrderBy (o => o.Price) .ThenBy (o => o.OrderID);
    a1.Dump ("a1");
    
    var a2 = MyOrders .AsQueryable () .OrderBy ("Price, OrderID");
    a2.Dump ("a2");
    
    var d1 = MyOrders .OrderByDescending (o => o.Price) .ThenByDescending (o => o.OrderID);
    d1.Dump ("d1");
    
    var d2 = MyOrders .AsQueryable () .OrderBy ("Price DESC, OrderID DESC");
    d2.Dump ("d2");
}

MyOrder [] MyOrders = new [] {
    new MyOrder { OrderID="1010", CustomerID="rnic", Description="optical mouse", Price=10.0000M, Items=1, }, 
    new MyOrder { OrderID="1020", CustomerID="rnic", Description="flash memory", Price=20.0000M, Items=2, }, 
    new MyOrder { OrderID="2010", CustomerID="sman", Description="digital camera", Price=20.0000M, Items=3, }, 
    new MyOrder { OrderID="2020", CustomerID="sman", Description="pocket pc", Price=20.0000M, Items=2, }, 
    new MyOrder { OrderID="2030", CustomerID="sman", Description="iphone", Price=20.0000M, Items=2, }, 
    new MyOrder { OrderID="3010", CustomerID="xyie", Description="distributed firewall", Price=25.0000M, Items=1, }, 
    new MyOrder { OrderID="3020", CustomerID="xyie", Description="byzantine node", Price=10.0000M, Items=4, }, 
    new MyOrder { OrderID="3030", CustomerID="xyie", Description="lamport snapshot", Price=15.0000M, Items=2, }, 
    new MyOrder { OrderID="4010", CustomerID="pdel", Description="cuda card", Price=40.0000M, Items=4, }, 
    new MyOrder { OrderID="5010", CustomerID="zwan", Description="usb drive", Price=15.0000M, Items=2, }, 
    new MyOrder { OrderID="5020", CustomerID="zwan", Description="keyboard", Price=10.0000M, Items=1, }, 
    new MyOrder { OrderID="5030", CustomerID="zwan", Description="mouse", Price=5.0000M, Items=3, }, 
};

public class MyOrder {
    public string OrderID { get; set; }
    public string CustomerID { get; set; }
    public string Description { get; set; }
    public decimal Price { get; set; }
    public int Items { get; set; }
}