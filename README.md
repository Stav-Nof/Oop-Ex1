In this assignment we were asked to write two class's, each one represents mathematical
Expressions, calculations and logical methods between them.

Monom (Monomial) - A class representing an object defined by the
structure a*x^b. in our case ‘a’ is a real number and ‘b’ is a natural number 
(if there is no 'a' or 'b' we are assuming that it equals to 1).
The class support operations as: Create new monom object and set the monom coefficient and the monom power. 
Create new monom object by other monom object (copy it). Sum and sub between two monoms, multiply, Derivative of the monom, 
calculate the monom value at specific point, compere two monoms and return true if they are equals, 
check whether the monom is the 'zero' monom.

Polynom (Polynomial)- A class representing a list of Monoms, defined by the structure a1*x^b1+a2*x^b2+…+an*x^bn. 
In our case, the expression can't consist more than one variable "x". 
This class support operations as: Create an empty polynom, create polynom object by type the polynom as a string. 
Create new polynom object by other polynom object (copy it), add monom to polynom, multiply polynom by monom and other polynom, 
sub and add between two polynoms, derivative , is-zero (return true if the polynom equal to zero), 
copy (deep copy of the polynom to a new one), iterator (return monoms iterator of the polynom), Calculate the polynomial value at point x, 
equals (return true if two polynoms are the same), find the root and area (compute Riemann's integral) functions.

MonomTest & polynomTest : Those classes testing minor and difficult cases of the methods at myMath. 
