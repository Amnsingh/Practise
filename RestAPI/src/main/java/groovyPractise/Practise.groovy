package groovyPractise

class Practise {
	static void main(String[] args) {
		
		def randString = "Random"
		//Ways of printing Output
		println("A $randString string")
		printf("A %s string \n", randString)
		printf("%-10s %d %.2f %10s \n",
			['Stuff',10,1.234,'Random'])
		
		//To take input
		print("Please Enter a name ");
	    def fName = System.in.newReader().readLine()
		println("Hello "+fName)
		
		print("Enter a number ")
		def num1 = System.in.newReader().readLine().toDouble()
		
		print("Enter a number ")
		def num2 = System.in.newReader().readLine().toDouble()
		
		printf("%.2f + %.2f = .2f\n",
			[num1,num2,(num1+num2)])
	
		
		//lists
		def primes = [2,3,5,7,11,13]
		println("2nd Prime "+ primes[1])
		println("3rd Prime "+primes.get(2))
		
		def employee = ['Aman',21,[1,2,8]]
		println("2nd number "+employee[2][2])
		
		println("Length "+primes.size())
		
		//add item in the list
		primes.add(17)
		primes<<19
		
		primes + [29,31]
		
		//Removing item from the list
		primes - [31]
		
		println("Is Empty "+primes.isEmpty())
		//Slicing a list
		println("1st three items "+primes[0..2])
		
		println(primes)
		
		println("Matches "+primes.intersect([2,3,7]))
		println("Reverse "+ primes.reverse())
		println("Sort "+primes.sort())
		println("Pop last element "+primes.pop())
	}
}
