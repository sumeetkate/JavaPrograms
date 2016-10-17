import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Comparator;

public class Homophones {
	
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		int k; 
		try
		{
		k = Integer.parseInt(args[0]);
		}
		
		catch (Exception e) 
		{
			k=5;// By Default Program will display top 5 words
		}
		
		// Please add path of input file here
		File file = new File("/afs/cad/courses/ccs/s16/cs/610/common/P1/cmudict.0.7a.txt");
		
		final HashMap<String, KeyValue> hm = new HashMap<String, KeyValue>();
		try
		{
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				if (line.substring(0, 3).equals(";;;"))
			          continue; // skip comment lines
			     int i = line.indexOf(' ');
			     String word = line.substring(0, i);
			     String phonemes = line.substring(i + 1);
			     	if ( hm.containsKey(phonemes))
			     	{
			     		KeyValue kv = hm.get(phonemes);
			     		kv.occurance++;
			     		hm.put(phonemes, kv);
			     	}
			     	else
			     	{	
			     		hm.put(phonemes,new KeyValue(1,word));
			     	}
			}
			scanner.close();
		}
		
		catch (FileNotFoundException e) 
		{
		      e.printStackTrace();
		}
		
		@SuppressWarnings("rawtypes")
		Map<String,KeyValue> sortedMap = new TreeMap<String,KeyValue> (
				 
				 new Comparator()
				 {
					@Override
					public int compare(Object o1, Object o2) 
					{
						final int v1 = hm.get(o1).getOccurance();
						final int v2 = hm.get(o2).getOccurance();
						if (v1>v2)
						{return -1;}
							
						return 1;					
					}
				 } 				 
				 );
		sortedMap.putAll(hm);
				
		for (Map.Entry<String, KeyValue> entry : sortedMap.entrySet()) 
		{
			if(--k<0)
		    	break;
		    KeyValue value = entry.getValue();
		    System.out.println(value.getWord()+" "+value.getOccurance());
		}
		
	}
}