OOP assignment Readme- Ex1

The project is about implement four classes, each one represents mathematical expressions, calculations and logical methods between them.

1)	Monom (Monomial) - A class represents an object defined by the structure a*x^b. in our case ‘a’ is a real number 
and ‘b’ is a natural number (if there is no 'a' or 'b' we are assuming that it equals to 1).
2)	Polynom (Polynomial)- A class represents a list of Monoms, defined by the structure a1*x^b1+a2*x^b2+…+an*x^bn.
3)	ComplexFunction - A class represents a complex function of type y=g(f1(x), f2(x)), where both f1 and f2 are simple functions 
(or complex functions), y and x are real numbers and g is an operation such as plus, mul, div, max and more.
4)	Function_GUI - A class represents an collections of functions (Monon, Polynom, ComplexFunction).

PolynomTest & ComplexFunctionTest & Function_GUITest & MononTest : Those are JUnit testers that test minor and difficult cases of the four classes methods.
