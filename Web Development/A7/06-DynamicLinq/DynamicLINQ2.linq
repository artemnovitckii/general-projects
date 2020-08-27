<Query Kind="Program">
  <Reference>DynamicLinqUoA.dll</Reference>
  <Namespace>System.Linq.Dynamic</Namespace>
</Query>

void Main() {
    var mylist = new List <MyCustomer> {
        new MyCustomer {CustomerID="rnic", Name="Radu", Age=52},
        new MyCustomer {CustomerID="yxin", Name="Xinfeng", Age=42},
        new MyCustomer {CustomerID="pdel", Name="Patrice", Age=42},
        new MyCustomer {CustomerID="sman", Name="Mano", Age=32}
    };
    
    var l1 = mylist .Where (c => c.Age > 40);
    l1 .Dump ();
    
    //var l2 = mylist.AsQueryable().Where("Age > 40"); 
    var l2 = mylist .AsQueryable () .Where ("Age > @0", 40); // AND Age < 50 
    l2 .Dump ();
}
    
class MyCustomer {
    public string CustomerID;
    public string Name;
    public int Age;
}