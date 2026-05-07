# Infix to Postfix Converter and Calculator

This Java program converts infix expressions (e.g., `3 + 5 * 2`) to postfix notation (e.g., `3 5 2 * +`) and evaluates the result.

## Features
Converts infix expressions to postfix notation. Evaluates postfix expressions. Supports operators: `+`, `-`, `*`, `/`, `^`. Handles parentheses and multi-digit numbers. Exits gracefully when no input is provided.

## How to Run
1. Compile the Java files: `javac *.java`
2. Run the program: `java Main`

## Usage
Enter an infix expression when prompted. The program will display the equivalent postfix expression and the evaluated result. Press `Enter` without typing anything to exit the program.

## Example
type your infix expression: (3 + 5) * 2  
converted to postfix: 3 5 + 2 *  
answer is 16.00

## File Structure
- `Main.java`: Entry point of the application.
- `Converter.java`: Converts infix expressions to postfix notation.
- `PostfixCalculator.java`: Evaluates postfix expressions.
- `ArrayStack.java`: Stack implementation used for expression parsing.
- `ParserHelper.java`: Helper class for parsing infix expressions.

## Requirements
Java 8 or higher.

## License
This project is licensed under the MIT License.
