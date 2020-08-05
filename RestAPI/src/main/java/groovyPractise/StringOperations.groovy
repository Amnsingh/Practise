package groovyPractise

class StringOperations {
	static void main(String[]args) {
		def name="Groovy";
		println('I am ${name}')
		println("I am ${name}")
		
		def multString = '''I am
		a String that goes 
		from many lines'''
		
		println(multString)
		println("3rd Index of name "+name[3])
		println("Index of r "+name.indexOf('v'))
		println("1st 3 characters "+name[0..2])
		print("Every Other Characters "+name[0,2,4])
		println("Substring at 1 "+name.substring(1))
		println("Substring at 1 to 4"+name.substring(1,4))
		println("My Name "+ name)
		println("My Name".concat(name))
		println("Check Equality "+('Groovy'.equals('Derek')))
		println("Check Equality Ignoring Case "+('Derek'.equalsIgnoreCase('derek')))
		println("Length "+name.length())
		
		def str = "Hello World"
		println(str - "Hello")
		println(str.split())
		println(str.toList())
		println(str.replaceAll('World', 'Groovy'))
		println("Ant <=> Banana "+('Ant'<=>'Banana')) 
		println("Banana<=>Ant "+('Banana'<=>'Ant'))
		println("Ant<=>Ant "+('Ant'<=>'Ant'))
	} 
}
