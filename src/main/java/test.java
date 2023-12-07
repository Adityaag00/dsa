import java.util.HashSet;

public class test {
	static final int MAXN = 500001;
	 
	   static int spf[] = new int[MAXN];
	     
	   
	   static void sieve()
	   {
	       spf[1] = 1;
	       for (int i=2; i<MAXN; i++)
	           spf[i] = i;
	       for (int i=4; i<MAXN; i+=2)
	           spf[i] = 2;
	     
	       for (int i=3; i*i<MAXN; i++)
	       {
	           if (spf[i] == i)
	           {
	               for (int j=i*i; j<MAXN; j+=i)
	                   if (spf[j]==j)
	                       spf[j] = i;
	           }
	       }
	   }
	   
	   public static void main(String[] args) {
		   int x=100;
		   int xx=x;
		   sieve();
		   HashSet<Integer> s=new HashSet<>();
		   
		   while(x!=1) {
			   s.add(spf[x]);
			   s.add(xx/spf[x]);
			   x/=spf[x];
		   }
		   for(int k:s) {
			   System.out.println(k);
		   }
	   }
}
