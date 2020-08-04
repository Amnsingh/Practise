package groovyPractise

class MathFunctions {
	static void main(String[] args) {
		def randNum = 2.0;
		println("Math.abs(-2.45) ="+(Math.abs(2.45)));
		println("Math.round(-2.45) ="+(Math.round(2.45)));
		println("randNum.pow(3) ="+(randNum.pow(3)))
		println("3.0.equals(2.0) ="+(3.0.equals(2.0)))
		println("randNum.equals(Float.NaN) ="+(randNum.equals(Float.NaN)))
		println("Math.sqrt(9) ="+(Math.sqrt(9)))
		println("Math.cbrt(27) ="+(Math.cbrt(27)))
		println("Math.ceil(2.45) ="+(Math.ceil(2.45)))
		println("Math.floor(2.45) ="+(Math.floor(2.45)))
		println("Math.min(2,3) ="+(Math.min(2,3)))
		println("Math.max(2,3) ="+(Math.max(2,3)))
		println("Math.log(2) ="+(Math.log(2)))
		println("Math.log10(2) ="+(Math.log10(2)))
		println("Math.toDegrees(Math.PI) ="+(Math.toDegrees(Math.PI))) 
		println("Math.toRadians(90) ="+(Math.toRadians(90)))
		println("Math.sin(0.5 * Math.PI) ="+(Math.sin(0.5 * Math.PI)))
		println("Math.abs(new Random().nextInt() % 100) + 1 ="+(Math.abs(new Random().nextInt() % 100) + 1))
	}

}
