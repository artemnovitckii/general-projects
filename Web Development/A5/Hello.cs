using System;
using System.IO;
using System.Text.RegularExpressions;
using System.Linq;

public class Programm
{
    

        public static void Main(string[] args)
        {
 
            string line;
            //string resultString;
            string oneBigString = " ";
            int counter = 0;
            
            
            try
            {   
                //getiing the first elemetn in string then change it to int
                string k = Console.ReadLine();
				k = Regex.Replace(k, @"\s+", "");
                int number_of_outputs =  Int32.Parse(k);
                //System.Console.WriteLine(number_of_outputs);

                Regex rgx = new Regex ("[^a-zA-Z]");

                while((line = Console.In.ReadLine()) != null)  
                {  
                	string line2 = rgx.Replace(line, " ");
                    
                    oneBigString += line2;
                } 
                //System.Console.WriteLine(oneBigString);
                string[] words = oneBigString.Split(null as char[], StringSplitOptions.RemoveEmptyEntries);
                var filteredWords = (words.Where(x => x.Length > 3)).ToArray();

				
				var frs = Frequencies (filteredWords);
				


				if(frs.Length <= number_of_outputs * 2){
                    foreach (var item in frs)
				    {
                        Console.WriteLine("{0} {1}", item.Item1, item.Item2);
                    }
                }

                else{
                    foreach (var item in frs)
                    {
                        if(counter < number_of_outputs){
                            Console.WriteLine("{0} {1}", item.Item1, item.Item2);   
                        }
                        counter += 1;
                    }
                    
                    for(int i = frs.Length - number_of_outputs; i < frs.Length; i++)
                    {
                        Console.WriteLine("{0} {1}", frs[i].Item1, frs[i].Item2);  
                    }

                }
	
                
            }
            catch (IOException e)
            {
                Console.WriteLine("The file could not be read:");
                Console.WriteLine(e.Message);
            }
        }

    public static(int, string)[] Frequencies (string[] words) 
    {
    var frs = words
    	.GroupBy (s => s.ToUpper()) // .Dump("GroupBy")
    	.Select (g => (g.Count(), g.Key)) // .Dump("Select")
        .OrderBy(x => x.Item2)
    	.OrderByDescending (w => w.Item1)       // .Dump("OrderBy")
        .ToArray ()
    	;
    return frs;
    }

}
