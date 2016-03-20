public enum operator {

	PLUS("+") {
		@Override
		public double calculate(float a, float b) {
			return a + b;
		}
	},
	MINUS("-") {
		@Override
		public double calculate(float a, float b) {
			return a - b;
		}
	},
	COMP("*") {
		@Override
		public double calculate(float a, float b) {
			return a * b;
		}
	},
	DIV("/") {
		@Override
		public double calculate(float a, float b) {
			return a / b;
		}
	};

	private String typeValue;

	private operator(String type) {
		typeValue = type;
	}

	static public operator getType(String pType) {
		for (operator type : operator.values()) {
			if (type.getTypeValue().equals(pType)) {
				return type;
			}
		}
		throw new RuntimeException("unknown symbol");
	}

	public String getTypeValue() {
		return typeValue;
	}

	public abstract double calculate(float a, float b);

}